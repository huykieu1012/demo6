package com.example.b5_hibernate.repositoty;

import com.example.b5_hibernate.dto.ChiTietSanPhamDTO;
import com.example.b5_hibernate.entity.*;
import com.example.b5_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

public class ChiTietSanPhamRepository {
    private MauSacRepository mauSacRepository = new MauSacRepository();
    private DongSPRepository dongSPRepository = new DongSPRepository();
    private  SanPhamRepositoty sanPhamRepositoty = new SanPhamRepositoty();
    private NSXRepositoory nsxRepositoory = new NSXRepositoory();


    public ArrayList<ChiTietSanPham> getAll() {
        ArrayList<ChiTietSanPham> list = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from  ChiTietSanPham ");
            list = (ArrayList<ChiTietSanPham>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ChiTietSanPham getById(UUID id){
        ChiTietSanPham chiTietSanPham = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            chiTietSanPham = session.get(ChiTietSanPham.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return chiTietSanPham;
    }

    public Boolean add(ChiTietSanPhamDTO chiTietSanPhamDTO) {
        Transaction transaction;

        MauSac mauSac = mauSacRepository.getByMa(chiTietSanPhamDTO.getTenMauSac());
        DongSP dongSP = dongSPRepository.getByMa(chiTietSanPhamDTO.getTenDongSP());
        SanPham sanPham = sanPhamRepositoty.getByMa(chiTietSanPhamDTO.getTenSanPham());
        NSX nsx = nsxRepositoory.getByMa(chiTietSanPhamDTO.getTenNSX());
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham(mauSac,sanPham,dongSP,nsx,chiTietSanPhamDTO.getNamBH(),chiTietSanPhamDTO.getMoTa(),chiTietSanPhamDTO.getSoLuongTon(),chiTietSanPhamDTO.getGiaNhap(),chiTietSanPhamDTO.getGiaBan());

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
//            System.out.println(chiTietSanPham.toString());
            session.save(chiTietSanPham);
            System.out.println("oke");
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean delete(ChiTietSanPham chiTietSanPham) {
        Transaction transaction;


        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();

            session.delete(chiTietSanPham);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public  Boolean update(ChiTietSanPhamDTO chiTietSanPhamDTO){
        Transaction transaction;

        MauSac mauSac = mauSacRepository.getByMa(chiTietSanPhamDTO.getTenMauSac());
        DongSP dongSP = dongSPRepository.getByMa(chiTietSanPhamDTO.getTenDongSP());
        SanPham sanPham = sanPhamRepositoty.getByMa(chiTietSanPhamDTO.getTenSanPham());
        NSX nsx = nsxRepositoory.getByMa(chiTietSanPhamDTO.getTenNSX());
        UUID idUpdate = chiTietSanPhamDTO.getId();
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham(idUpdate,mauSac,sanPham,dongSP,nsx,chiTietSanPhamDTO.getNamBH(),chiTietSanPhamDTO.getMoTa(),chiTietSanPhamDTO.getSoLuongTon(),chiTietSanPhamDTO.getGiaNhap(),chiTietSanPhamDTO.getGiaBan());

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
//            System.out.println(chiTietSanPham.toString());
            session.merge(chiTietSanPham);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {

    ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

        BigDecimal bigDecimal = new BigDecimal(223.121455);
        BigDecimal bigDecimal1 = new BigDecimal(243.121455);
        ChiTietSanPhamDTO chiTietSanPhamDTO = new ChiTietSanPhamDTO(2003, "a", 42, bigDecimal, bigDecimal1, "a","bbbb","aa","d");
    chiTietSanPhamRepository.add(chiTietSanPhamDTO);

    }

}
