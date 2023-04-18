package com.example.b5_hibernate.repositoty;

import com.example.b5_hibernate.entity.CuaHang;

import com.example.b5_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class CuaHangRepository {
    public ArrayList<CuaHang> getAll(){
        ArrayList<CuaHang> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from CuaHang ");
            list = (ArrayList<CuaHang>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public CuaHang getById(UUID id){
        CuaHang cuaHang = new CuaHang();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            cuaHang = session.get(CuaHang.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cuaHang;

    }
    public CuaHang getByMa(String ten){
        CuaHang cuaHang = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from CuaHang where  ma = :ten");
            query.setParameter("ten",ten);
            cuaHang = (CuaHang) query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  cuaHang;
    }
    public Boolean add(CuaHang cuaHang){
        Transaction transaction;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(CuaHang cuaHang){
        Transaction transaction;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.merge(cuaHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        CuaHangRepository cuaHangRepository = new CuaHangRepository();
        System.out.println(cuaHangRepository.getByMa("a").toString());
    }
}
