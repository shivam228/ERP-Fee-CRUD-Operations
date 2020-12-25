package com.example.erp.dao.impl;
import javax.persistence.*;
import com.example.erp.bean.Bill;
import com.example.erp.bean.student;
import com.example.erp.dao.BillsDAO;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;

import java.util.List;

public class BillsDAOimpl implements BillsDAO {

    public  void addBill(Bill b){
        try(Session session = SessionUtil.getSession())
        {
            session.beginTransaction();
            session.save(b);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delBill(Integer billId)
    {
        try(Session session = SessionUtil.getSession())
        {
            session.beginTransaction();
            TypedQuery<Bill> query = session.createQuery("delete from Bill where id=:bid");
            query.setParameter("bid", billId);
            int result = query.executeUpdate();
            //System.out.println("Rows affected: " + result);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public Bill getbill(int billId)
    {
        Session session = SessionUtil.getSession();

            session.beginTransaction();
            Bill b = session.get(Bill.class,billId);
            session.getTransaction().commit();
        session.close();
            return b;
    }

    @Override
    public void updateBillAmt(int billId, int amount)
    {
        try(Session session = SessionUtil.getSession())
        {
            session.beginTransaction();
            TypedQuery<Bill> query = session.createQuery("update Bill set amount=:amt where id=:ids");
            query.setParameter("amt", amount);
            query.setParameter("ids", billId);
            int modifications=query.executeUpdate();
            System.out.println(modifications);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateBillDate(Integer billId, String date)
    {
        try(Session session = SessionUtil.getSession())
        {
            session.beginTransaction();
            TypedQuery<Bill> query = session.createQuery("update Bill set deadline=:dat where id=:id");
            query.setParameter("dat", date);
            query.setParameter("id", billId);
            int modifications=query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }


    public List<Bill> getAllBill(){

        Session session = SessionUtil.getSession();

        session.beginTransaction();
        TypedQuery<Bill> query = session.createQuery("from Bill ");
        List<Bill> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;


    }


}
