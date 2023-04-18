package com.example.b5_hibernate.dto;


import java.math.BigDecimal;
import java.util.UUID;

public class ChiTietSanPhamDTO {
    private UUID id;

    private Integer namBH;


    private String moTa;


    private Integer soLuongTon;


    private BigDecimal giaNhap;


    private BigDecimal giaBan;
    private String tenMauSac;
    private String tenSanPham;
    private String tenDongSP;
    private String tenNSX;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNamBH() {
        return namBH;
    }

    public void setNamBH(Integer namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenDongSP() {
        return tenDongSP;
    }

    public void setTenDongSP(String tenDongSP) {
        this.tenDongSP = tenDongSP;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public ChiTietSanPhamDTO(Integer namBH, String moTa, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, String tenMauSac, String tenSanPham, String tenDongSP, String tenNSX) {
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.tenMauSac = tenMauSac;
        this.tenSanPham = tenSanPham;
        this.tenDongSP = tenDongSP;
        this.tenNSX = tenNSX;
    }

    public ChiTietSanPhamDTO(UUID id, Integer namBH, String moTa, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, String tenMauSac, String tenSanPham, String tenDongSP, String tenNSX) {
        this.id = id;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.tenMauSac = tenMauSac;
        this.tenSanPham = tenSanPham;
        this.tenDongSP = tenDongSP;
        this.tenNSX = tenNSX;
    }
}
