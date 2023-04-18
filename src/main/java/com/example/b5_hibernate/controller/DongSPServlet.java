package com.example.b5_hibernate.controller;

import com.example.b5_hibernate.entity.DongSP;
import com.example.b5_hibernate.entity.NSX;
import com.example.b5_hibernate.repositoty.DongSPRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {"/dong-sp/hien-thi",
        "/dong-sp/add",
        "/dong-sp/detail",
        "/dong-sp/remove",
        "/dong-sp/update"})
public class DongSPServlet extends HttpServlet {
private DongSPRepository dongSPRepository = new DongSPRepository();
private UUID idUpdate;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            request.setAttribute("listDongSP", dongSPRepository.getAll());
            request.getRequestDispatcher("/view/dong-sp/hienThi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            idUpdate = id;
            DongSP dongSP = dongSPRepository.getById(id);
            request.setAttribute("dongSP", dongSP);
            request.getRequestDispatcher("/view/dong-sp/detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dongSP = new DongSP(ma, ten);
            dongSPRepository.add(dongSP);
            response.sendRedirect("/dong-sp/hien-thi");
        } else if (uri.contains("update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dongSP = new DongSP(idUpdate,ma, ten);
            dongSPRepository.update(dongSP);
            response.sendRedirect("/dong-sp/hien-thi");
        }
    }
}
