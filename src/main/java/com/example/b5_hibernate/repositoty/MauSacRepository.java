package com.example.b5_hibernate.repositoty;

import com.example.b5_hibernate.entity.MauSac;
import com.example.b5_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class MauSacRepository {

    public ArrayList<MauSac> getAll(){
        ArrayList<MauSac> listMauSac = new ArrayList<>();

        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from MauSac ");
            listMauSac = (ArrayList<MauSac>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listMauSac;
    }
    public MauSac getByID(UUID id){
        MauSac mauSac = new MauSac();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            mauSac = session.get(MauSac.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mauSac;
    }
    public MauSac getByMa(String ten){
        MauSac mauSac = new MauSac();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac p WHERE p.ma = :id1");
            query.setParameter("id1",ten);
            mauSac = (MauSac) query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return mauSac;
    }

    public Boolean add(MauSac mauSac){
        Transaction transaction;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(MauSac mauSac) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        MauSacRepository mauSacRepository = new MauSacRepository();
        MauSac mauSac = mauSacRepository.getByMa("a");
        System.out.println(mauSac.toString());
    }
}
