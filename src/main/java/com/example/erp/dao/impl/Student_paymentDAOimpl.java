package com.example.erp.dao.impl;

import com.example.erp.bean.Bill;
import com.example.erp.bean.Student_payment;
import com.example.erp.bean.student;
import com.example.erp.dao.Student_PaymentDAO;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;


public class Student_paymentDAOimpl implements Student_PaymentDAO {

    @Override
    public List<Student_payment> getPayment() {
        Session session = SessionUtil.getSession();

        session.beginTransaction();
        TypedQuery<Student_payment> query = session.createQuery("from Student_payment");
        List<Student_payment> result = query.getResultList();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public void addPayment(Student_payment s) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delBills(Integer billId) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            TypedQuery<Student_payment> query = session.createQuery("delete from Student_payment where id=:bid");
            query.setParameter("bid", billId);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
