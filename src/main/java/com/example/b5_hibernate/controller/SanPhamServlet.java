package com.example.b5_hibernate.controller;

import com.example.b5_hibernate.entity.NSX;
import com.example.b5_hibernate.entity.SanPham;
import com.example.b5_hibernate.repositoty.SanPhamRepositoty;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {"/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/detail",
        "/san-pham/remove",
        "/san-pham/update"})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepositoty sanPhamRepositoty = new SanPhamRepositoty();
    private UUID idUpdate;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            request.setAttribute("listSanPham", sanPhamRepositoty.getAll());
            request.getRequestDispatcher("/view/san-pham/hienThi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            idUpdate = id;
            SanPham sanPham = sanPhamRepositoty.getById(id);
            request.setAttribute("sanPham", sanPham);
            request.getRequestDispatcher("/view/san-pham/detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sanPham = new SanPham(ma, ten);
            sanPhamRepositoty.add(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        } else if (uri.contains("update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sanPham = new SanPham(idUpdate,ma, ten);
            sanPhamRepositoty.update(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }
}
