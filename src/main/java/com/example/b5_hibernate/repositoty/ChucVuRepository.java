package com.example.b5_hibernate.repositoty;

import com.example.b5_hibernate.entity.ChucVu;


import com.example.b5_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class ChucVuRepository {

    public ArrayList<ChucVu> getAll(){
        ArrayList<ChucVu> listChuVu = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from ChucVu ");
            listChuVu = (ArrayList<ChucVu>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }

        return listChuVu;
    }

    public ChucVu getById(UUID id){
        ChucVu chucVu = new ChucVu();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            chucVu = session.get(ChucVu.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return chucVu;
    }

    public  ChucVu getByMa(String ten){
        ChucVu chucVu = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from  ChucVu  where  ma = :ten");
            query.setParameter("ten",ten);
            chucVu = (ChucVu) query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return chucVu;
    }

    public Boolean add(ChucVu chucVu){
        Transaction transaction;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(ChucVu chucVu){
        Transaction transaction=null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.merge(chucVu);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        ChucVuRepository chucVuRepository = new ChucVuRepository();
        System.out.println(chucVuRepository.getByMa("nbbbb").toString());
    }
}
