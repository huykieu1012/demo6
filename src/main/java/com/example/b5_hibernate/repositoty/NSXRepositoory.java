package com.example.b5_hibernate.repositoty;

import com.example.b5_hibernate.entity.NSX;
import com.example.b5_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class NSXRepositoory {
    public ArrayList<NSX> getAll(){
        ArrayList<NSX> listNSX = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from NSX");
            listNSX = (ArrayList<NSX>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  listNSX;
    }
public NSX getById(UUID id){
        NSX nsx = new NSX();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            nsx = session.get(NSX.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nsx;
}
    public Boolean add(NSX nsx){
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public NSX getByMa(String ten){
        NSX nsx = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from NSX  where ma = :ten");
            query.setParameter("ten",ten);
            nsx = (NSX) query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return nsx;
    }
    public Boolean update(NSX nsx){
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.update(nsx);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public static void main(String[] args) {
        NSXRepositoory nsxRepositoory = new NSXRepositoory();
        System.out.println(nsxRepositoory.getByMa("11").toString());
    }
}
