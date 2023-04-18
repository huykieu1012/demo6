package com.example.b5_hibernate.repositoty;

import com.example.b5_hibernate.dto.NhanVienDTO;
import com.example.b5_hibernate.entity.ChucVu;
import com.example.b5_hibernate.entity.CuaHang;
import com.example.b5_hibernate.entity.NhanVien;
import com.example.b5_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class NhanVienRepositoty {

    private ChucVuRepository chucVuRepository = new ChucVuRepository();
    private  CuaHangRepository cuaHangRepository = new CuaHangRepository();
public ArrayList<NhanVien> getAll(){
    ArrayList<NhanVien> list = null;
    try(Session session = HibernateUtil.getFACTORY().openSession()){
        Query query = session.createQuery("from NhanVien ");
        list = (ArrayList<NhanVien>) query.getResultList();
    }catch (Exception e){
        e.printStackTrace();
    }
    return list;
}

public NhanVien getById(UUID id){
    NhanVien nhanVien = null;
    try(Session session = HibernateUtil.getFACTORY().openSession()){
        nhanVien =session.get(NhanVien.class,id);
    }catch (Exception e){
        e.printStackTrace();
    }
    return nhanVien;
}
    public Boolean add(NhanVienDTO nhanVienDTO){
        Transaction transaction;
        ChucVu chucVu = chucVuRepository.getByMa(nhanVienDTO.getTenCV());
        CuaHang cuaHang = cuaHangRepository.getByMa(nhanVienDTO.getTenCH());

        NhanVien nhanVien = new NhanVien(nhanVienDTO.getMa(),nhanVienDTO.getTen(),nhanVienDTO.getTenDem(),nhanVienDTO.getHo(),nhanVienDTO.getGioiTinh(),nhanVienDTO.getNgaySinh(),nhanVienDTO.getDiaChi(),nhanVienDTO.getSdt(),nhanVienDTO.getMatKhau(),chucVu,cuaHang,nhanVienDTO.getTrangThai());
        try(Session session = HibernateUtil.getFACTORY().openSession()){
           transaction = session.beginTransaction();
           session.save(nhanVien);
           transaction.commit();
           return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Boolean delete(NhanVien nhanVien){
        Transaction transaction;
//        ChucVu chucVu = chucVuRepository.getByMa(nhanVienDTO.getTenCV());
//        CuaHang cuaHang = cuaHangRepository.getByMa(nhanVienDTO.getTenCH());

//        NhanVien nhanVien = new NhanVien(nhanVienDTO.getMa(),nhanVienDTO.getTen(),nhanVienDTO.getTenDem(),nhanVienDTO.getHo(),nhanVienDTO.getGioiTinh(),nhanVienDTO.getNgaySinh(),nhanVienDTO.getDiaChi(),nhanVienDTO.getSdt(),nhanVienDTO.getMatKhau(),chucVu,cuaHang,nhanVienDTO.getTrangThai());
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(NhanVienDTO nhanVienDTO){
        Transaction transaction;
        ChucVu chucVu = chucVuRepository.getByMa(nhanVienDTO.getTenCV());
        CuaHang cuaHang = cuaHangRepository.getByMa(nhanVienDTO.getTenCH());
UUID idUpdate = nhanVienDTO.getId();
        NhanVien nhanVien = new NhanVien(idUpdate,nhanVienDTO.getMa(),nhanVienDTO.getTen(),nhanVienDTO.getTenDem(),nhanVienDTO.getHo(),nhanVienDTO.getGioiTinh(),nhanVienDTO.getNgaySinh(),nhanVienDTO.getDiaChi(),nhanVienDTO.getSdt(),nhanVienDTO.getMatKhau(),chucVu,cuaHang,nhanVienDTO.getTrangThai());
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

//    public static void main(String[] args) {
//        NhanVienRepositoty nhanVienRepositoty = new NhanVienRepositoty();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date ngaySinh ;
//        try {
//            ngaySinh = dateFormat.parse("2003-12-10");
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        NhanVienDTO nhanVienDTO = new NhanVienDTO("m1","huy","quang","Kieu","nam",ngaySinh,"Ha noi","09999","123456",1,"aa","a");
//nhanVienRepositoty.add(nhanVienDTO);
//    }
}
