package com.example.b5_hibernate.controller;

import com.example.b5_hibernate.entity.CuaHang;
import com.example.b5_hibernate.entity.MauSac;
import com.example.b5_hibernate.repositoty.CuaHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet",value = {"/cua-hang/hien-thi",
        "/cua-hang/add",
        "/cua-hang/detail",
        "/cua-hang/remove",
        "/cua-hang/update"})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    private UUID idUpdate;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/hien-thi")){
            request.setAttribute("listCuaHang",cuaHangRepository.getAll());
            request.getRequestDispatcher("/view/cua-hang/hienThi.jsp").forward(request,response);
        }else if(uri.contains("/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            idUpdate = id;
            CuaHang cuaHang = cuaHangRepository.getById(id);
            request.setAttribute("cuaHang",cuaHang);
            request.getRequestDispatcher("/view/cua-hang/detail.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");

            CuaHang cuaHang = new CuaHang(ma, ten,diaChi,thanhPho,quocGia);
            cuaHangRepository.add(cuaHang);
            response.sendRedirect("/cua-hang/hien-thi");
        } else if (uri.contains("update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");

            CuaHang cuaHang = new CuaHang(idUpdate,ma, ten,diaChi,thanhPho,quocGia);
            cuaHangRepository.update(cuaHang);
            response.sendRedirect("/cua-hang/hien-thi");
        }
    }
}
