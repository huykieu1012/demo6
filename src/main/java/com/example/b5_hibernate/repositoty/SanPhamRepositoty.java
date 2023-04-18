package com.example.b5_hibernate.repositoty;

import com.example.b5_hibernate.entity.SanPham;
import com.example.b5_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class SanPhamRepositoty {
    public ArrayList<SanPham> getAll(){
        ArrayList<SanPham> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from SanPham ");
            list = (ArrayList<SanPham>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public SanPham getById(UUID id){
        SanPham sanPham = new SanPham();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
           sanPham = session.get(SanPham.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sanPham;
    }
    public SanPham getByMa(String ten){
        SanPham sanPham = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from SanPham where ma = :ten");
            query.setParameter("ten",ten);
            sanPham = (SanPham) query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  sanPham;
    }
    public Boolean add(SanPham sanPham){
        Transaction transaction;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(SanPham sanPham){
        Transaction transaction;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.merge(sanPham);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SanPhamRepositoty sanPhamRepositoty = new SanPhamRepositoty();
        System.out.println(sanPhamRepositoty.getByMa("11111").toString());
    }
}
