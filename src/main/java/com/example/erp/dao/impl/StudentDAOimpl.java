package com.example.erp.dao.impl;

import com.example.erp.bean.Bill;
import com.example.erp.bean.student;
import javax.persistence.*;

import com.example.erp.dao.StudentDAO;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class StudentDAOimpl implements StudentDAO {
    public void addStudent(student s)
    {
        try(Session session = SessionUtil.getSession())
        {
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }

    }
    public List<student> getStudent(String Dept)
    {
        Session session = SessionUtil.getSession();
            session.beginTransaction();
            TypedQuery<student> query = session.createQuery("from student s1 where s1.department =:drt");
            query.setParameter("drt",Dept);
            List<student> result = query.getResultList();
            session.getTransaction().commit();
        session.close();
        return result;
    }


    public List<student> getAllStudents()
    {
        Session session = SessionUtil.getSession();
            session.beginTransaction();
            TypedQuery<student> query = session.createQuery("from student");
            List<student> result = query.getResultList();
            session.getTransaction().commit();
            return result;
    }

    @Override
    public student getstudent(int id)
    {
        Session session = SessionUtil.getSession();

        session.beginTransaction();
        student s = session.get(student.class,id);
        session.getTransaction().commit();
        session.close();
        return s;
    }

}
