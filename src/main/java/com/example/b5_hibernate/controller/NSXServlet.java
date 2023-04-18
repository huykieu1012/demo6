package com.example.b5_hibernate.controller;

import com.example.b5_hibernate.entity.NSX;
import com.example.b5_hibernate.repositoty.NSXRepositoory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "NSXServlet", value = {"/nsx/hien-thi",
        "/nsx/add",
        "/nsx/detail",
        "/nsx/remove",
        "/nsx/update"})
public class NSXServlet extends HttpServlet {
    private NSXRepositoory nsxRepositoory = new NSXRepositoory();
    private UUID idUpdate;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            request.setAttribute("listNSX", nsxRepositoory.getAll());
            request.getRequestDispatcher("/view/nsx/hienThi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            idUpdate = id;
            NSX nsx = nsxRepositoory.getById(id);
            request.setAttribute("nsx", nsx);
            request.getRequestDispatcher("/view/nsx/detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX(ma, ten);
            nsxRepositoory.add(nsx);
            response.sendRedirect("/nsx/hien-thi");
        } else if (uri.contains("update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX(idUpdate, ma, ten);
            nsxRepositoory.update(nsx);
            response.sendRedirect("/nsx/hien-thi");
        }
    }
}
