package com.example.b5_hibernate.controller;

import com.example.b5_hibernate.entity.ChucVu;
import com.example.b5_hibernate.repositoty.ChucVuRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet",value = {"/chuc-vu/hien-thi",
        "/chuc-vu/add",
        "/chuc-vu/detail",
        "/chuc-vu/remove",
        "/chuc-vu/update"})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository chucVuRepository = new ChucVuRepository();
    private UUID idUpdate ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/hien-thi")){
            ArrayList<ChucVu> listChucVu =chucVuRepository.getAll();
            request.setAttribute("listChucVu",listChucVu);
            request.getRequestDispatcher("/view/chuc-vu/chucVu.jsp").forward(request,response);

        }else  if(uri.contains("/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            idUpdate = id;
            ChucVu chucVu = chucVuRepository.getById(id);
            request.setAttribute("chucVu",chucVu);
            request.getRequestDispatcher("/view/chuc-vu/detail.jsp").forward(request,response);
        }

        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu(ma,ten);
            chucVuRepository.add(chucVu);
            response.sendRedirect("/chuc-vu/hien-thi");
        }else if(uri.contains("/update")){
            System.out.println(idUpdate);
//            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu(idUpdate,ma,ten);
            chucVuRepository.update(chucVu);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }
}
