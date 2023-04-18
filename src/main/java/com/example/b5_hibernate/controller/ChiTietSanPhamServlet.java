package com.example.b5_hibernate.controller;

import com.example.b5_hibernate.dto.ChiTietSanPhamDTO;
import com.example.b5_hibernate.entity.*;
import com.example.b5_hibernate.repositoty.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;


@WebServlet(name = "ChiTietSanPhamServlet", value = {"/chi-tiet-sp/hien-thi",
        "/chi-tiet-sp/add",
        "/chi-tiet-sp/detail",
        "/chi-tiet-sp/remove",
        "/chi-tiet-sp/update"})
public class ChiTietSanPhamServlet extends HttpServlet {
    private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();
    private MauSacRepository mauSacRepository = new MauSacRepository();
    private SanPhamRepositoty sanPhamRepositoty = new SanPhamRepositoty();
    private NSXRepositoory nsxRepositoory = new NSXRepositoory();
    private DongSPRepository dongSPRepository = new DongSPRepository();
private UUID idUpdate;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            ArrayList<ChiTietSanPham> list = chiTietSanPhamRepository.getAll();
            ArrayList<MauSac> listMauSac = mauSacRepository.getAll();
            ArrayList<DongSP> listDongSP = dongSPRepository.getAll();
            ArrayList<NSX> listNSX = nsxRepositoory.getAll();
            ArrayList<SanPham> listSanPham = sanPhamRepositoty.getAll();
            request.setAttribute("listChiTietSP", list);
            request.setAttribute("listDongSP", listDongSP);
            request.setAttribute("listNSX", listNSX);
            request.setAttribute("listSanPham", listSanPham);
            request.setAttribute("listMauSac", listMauSac);
            request.getRequestDispatcher("/view/chi-tiet-san-pham/hienThi.jsp").forward(request, response);
        }else if(uri.contains("/detail")){
            ArrayList<MauSac> listMauSac = mauSacRepository.getAll();
            ArrayList<DongSP> listDongSP = dongSPRepository.getAll();
            ArrayList<NSX> listNSX = nsxRepositoory.getAll();
            ArrayList<SanPham> listSanPham = sanPhamRepositoty.getAll();
            UUID id = UUID.fromString(request.getParameter("id"));
            idUpdate = id;
            ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.getById(id);
            request.setAttribute("chiTietSP",chiTietSanPham);
            request.setAttribute("listDongSP", listDongSP);
            request.setAttribute("listNSX", listNSX);
            request.setAttribute("listSanPham", listSanPham);
            request.setAttribute("listMauSac", listMauSac);
            request.getRequestDispatcher("/view/chi-tiet-san-pham/detail.jsp").forward(request,response);

        }else if(uri.contains("/remove")){
            UUID id = UUID.fromString(request.getParameter("id"));

            ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.getById(id);
            chiTietSanPhamRepository.delete(chiTietSanPham);
            ArrayList<ChiTietSanPham> list = chiTietSanPhamRepository.getAll();
            request.setAttribute("listChiTietSP", list);
            request.getRequestDispatcher("/view/chi-tiet-san-pham/hienThi.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String tenMauSac = request.getParameter("tenMauSac");
            String tenSanPham = request.getParameter("tenSanPham");
            String tenDongSP = request.getParameter("tenDongSP");
            String tenNSX = request.getParameter("tenNSX");
            Integer namBH = Integer.parseInt(request.getParameter("namBH"));
            String moTa = request.getParameter("moTa");
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            double giaNhap1 = Double.parseDouble(request.getParameter("giaNhap"));
            double giaBan1 = Double.parseDouble(request.getParameter("giaBan"));

            BigDecimal giaNhap = BigDecimal.valueOf(giaNhap1);
            BigDecimal giaBan = BigDecimal.valueOf(giaBan1);
            ChiTietSanPhamDTO chiTietSanPhamDTO = new ChiTietSanPhamDTO(namBH,moTa,soLuongTon,giaNhap,giaBan,tenMauSac,tenSanPham,tenDongSP,tenNSX);
            chiTietSanPhamRepository.add(chiTietSanPhamDTO);
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        }else if(uri.contains("/update")){
            String tenMauSac = request.getParameter("tenMauSac");
            String tenSanPham = request.getParameter("tenSanPham");
            String tenDongSP = request.getParameter("tenDongSP");
            String tenNSX = request.getParameter("tenNSX");
            Integer namBH = Integer.parseInt(request.getParameter("namBH"));
            String moTa = request.getParameter("moTa");
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            double giaNhap1 = Double.parseDouble(request.getParameter("giaNhap"));
            double giaBan1 = Double.parseDouble(request.getParameter("giaBan"));

            BigDecimal giaNhap = BigDecimal.valueOf(giaNhap1);
            BigDecimal giaBan = BigDecimal.valueOf(giaBan1);
            ChiTietSanPhamDTO chiTietSanPhamDTO = new ChiTietSanPhamDTO(idUpdate,namBH,moTa,soLuongTon,giaNhap,giaBan,tenMauSac,tenSanPham,tenDongSP,tenNSX);
            chiTietSanPhamRepository.update(chiTietSanPhamDTO);
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        }
    }
}
