package com.example.b5_hibernate.entity;

import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;
import java.util.UUID;

@Table(name = "ChucVu")
@Entity
public class ChucVu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chucVu")
    private Set<NhanVien> listNhanVien = new HashSet<>();

    public Set<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public void setListNhanVien(Set<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    public ChucVu() {
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

    public ChucVu(UUID id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public ChucVu(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "ChucVu{" +
                "id='" + id + '\'' +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                '}';
    }
}
