package com.example.erp.dao.impl;

import com.example.erp.bean.student;
import com.example.erp.dao.UserDAO;
import com.example.erp.bean.User;
import com.example.erp.utils.SessionUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimpl implements UserDAO
{

    @Override
    public String login(String user, String pass)
    {
        List<User> nakli = new ArrayList<User>();
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        TypedQuery<User> query = session.createQuery("from User u1 where u1.name =:users");
        query.setParameter("users",user);
        nakli = query.getResultList();
        session.getTransaction().commit();
        session.close();
        if(nakli.get(0).getPassword().equals(pass))
        {
            return "success";
        }
        else
            return "failure";


    }
}
