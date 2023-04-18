package com.example.b5_hibernate.controller;

import com.example.b5_hibernate.entity.MauSac;
import com.example.b5_hibernate.entity.NSX;
import com.example.b5_hibernate.repositoty.MauSacRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "MauSacServlet",value = {"/mau-sac/hien-thi",
        "/mau-sac/add",
        "/mau-sac/detail",
        "/mau-sac/remove",
        "/mau-sac/update"})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository = new MauSacRepository();
    private UUID idUpdate;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/hien-thi")){
            request.setAttribute("listMauSac",mauSacRepository.getAll());
            request.getRequestDispatcher("/view/mau-sac/hienThi.jsp").forward(request,response);
        }else if(uri.contains("/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            idUpdate = id;
            MauSac mauSac = mauSacRepository.getByID(id);
            request.setAttribute("mauSac",mauSac);
            request.getRequestDispatcher("/view/mau-sac/detail.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            MauSac mauSac = new MauSac(ma, ten);
            mauSacRepository.add(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");
        } else if (uri.contains("update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            MauSac mauSac = new MauSac(idUpdate,ma, ten);
            mauSacRepository.update(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }
}
