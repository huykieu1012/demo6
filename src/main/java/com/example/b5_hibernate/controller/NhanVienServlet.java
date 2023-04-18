package com.example.b5_hibernate.controller;

import com.example.b5_hibernate.dto.NhanVienDTO;
import com.example.b5_hibernate.entity.ChucVu;
import com.example.b5_hibernate.entity.CuaHang;
import com.example.b5_hibernate.entity.NhanVien;
import com.example.b5_hibernate.repositoty.ChucVuRepository;
import com.example.b5_hibernate.repositoty.CuaHangRepository;
import com.example.b5_hibernate.repositoty.NhanVienRepositoty;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {"/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/detail",
        "/nhan-vien/remove",
        "/nhan-vien/update"})
public class NhanVienServlet extends HttpServlet {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private NhanVienRepositoty nhanVienRepositoty = new NhanVienRepositoty();
    private ChucVuRepository chucVuRepository = new ChucVuRepository();
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    private UUID idUpdate;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uri = request.getRequestURI();
            if(uri.contains("/hien-thi")){
                ArrayList<NhanVien> listNhanVien = nhanVienRepositoty.getAll();
                ArrayList<CuaHang> listCuaHang = cuaHangRepository.getAll();
                ArrayList<ChucVu> listChucVu = chucVuRepository.getAll();
                request.setAttribute("listNhanVien",listNhanVien);
                request.setAttribute("listCuaHang",listCuaHang);
                request.setAttribute("listChucVu",listChucVu);
                request.getRequestDispatcher("/view/nhan-vien/hienThi.jsp").forward(request,response);
            }else  if(uri.contains("/detail")){
                UUID id = UUID.fromString(request.getParameter("id"));
                idUpdate = id;
                NhanVien nhanVien = nhanVienRepositoty.getById(id);
                ArrayList<CuaHang> listCuaHang = cuaHangRepository.getAll();
                ArrayList<ChucVu> listChucVu = chucVuRepository.getAll();
                String ngaySinh = dateFormat.format(nhanVien.getNgaySinh());
                request.setAttribute("ngaySinh", ngaySinh);
                request.setAttribute("nhanVien",nhanVien);
                request.setAttribute("listCuaHang",listCuaHang);
                request.setAttribute("listChucVu",listChucVu);
                request.getRequestDispatcher("/view/nhan-vien/detail.jsp").forward(request,response);
            }else if(uri.contains("/remove")){
                UUID id = UUID.fromString(request.getParameter("id"));

                NhanVien nhanVien = nhanVienRepositoty.getById(id);
                nhanVienRepositoty.delete(nhanVien);
                ArrayList<NhanVien> listNhanVien = nhanVienRepositoty.getAll();
                request.setAttribute("listNhanVien",listNhanVien);
                request.getRequestDispatcher("/view/nhan-vien/hienThi.jsp").forward(request,response);
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String uri = request.getRequestURI();
        if(uri.contains("/add")){
           String ma = request.getParameter("ma");
           String ten = request.getParameter("ten");
           String tenDem = request.getParameter("tenDem");
           String ho = request.getParameter("ho");
           String gioiTinh = request.getParameter("gioiTinh");

            Date ngaySinh ;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));
            String chucVu = request.getParameter("tenChucVu");
            String cuaHang = request.getParameter("tenCuaHang");
            NhanVienDTO nhanVienDTO = new NhanVienDTO(ma,ten,tenDem,ho,gioiTinh,ngaySinh,diaChi,sdt,matKhau,trangThai,chucVu,cuaHang);
            nhanVienRepositoty.add(nhanVienDTO);
            response.sendRedirect("/nhan-vien/hien-thi");
        }else  if(uri.contains("/update")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");

            Date ngaySinh ;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));
            String chucVu = request.getParameter("tenChucVu");
            String cuaHang = request.getParameter("tenCuaHang");
            System.out.println(chucVu);
            System.out.println(trangThai);
            NhanVienDTO nhanVienDTO = new NhanVienDTO(idUpdate,ma,ten,tenDem,ho,gioiTinh,ngaySinh,diaChi,sdt,matKhau,trangThai,chucVu,cuaHang);
            nhanVienRepositoty.update(nhanVienDTO);
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }
}
