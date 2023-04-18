package com.example.b5_hibernate.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "NSX")
@Entity
public class NSX {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nsx")
    private Set<ChiTietSanPham> listChiTietSanPham = new HashSet<>();

    public Set<ChiTietSanPham> getListChiTietSanPham() {
        return listChiTietSanPham;
    }

    public void setListChiTietSanPham(Set<ChiTietSanPham> listChiTietSanPham) {
        this.listChiTietSanPham = listChiTietSanPham;
    }

    public NSX() {
    }

    public NSX(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public NSX(UUID id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "NSX{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +

                '}';
    }
}

