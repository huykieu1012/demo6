package com.example.b5_hibernate.repositoty;

import com.example.b5_hibernate.entity.DongSP;
import com.example.b5_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class DongSPRepository {
    public ArrayList<DongSP> getAll(){
        ArrayList<DongSP> listDongSP = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from DongSP ");
            listDongSP = (ArrayList<DongSP>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();

        }
        return listDongSP;
    }
    public DongSP getById(UUID id){
        DongSP dongSP = new DongSP();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            dongSP = session.get(DongSP.class,id);
        }catch (Exception e){
            e.printStackTrace();

        }
        return dongSP;
    }
    public Boolean add(DongSP dongSP){
        Transaction transaction;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(dongSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;

        }
    }
    public Boolean update(DongSP dongSP){
        Transaction transaction;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.merge(dongSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;

        }
    }
    public DongSP getByMa(String ten){
        DongSP dongSP = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from DongSP  where ma = :ten");
            query.setParameter("ten",ten);
            dongSP = (DongSP) query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dongSP;
    }

    public static void main(String[] args) {
        DongSPRepository s = new DongSPRepository();
        ArrayList<DongSP> list = s.getAll();
//        for(DongSP x :list ){
//            System.out.println(x.toString());
//        }
        System.out.println(s.getByMa("abc"));
    }
}
