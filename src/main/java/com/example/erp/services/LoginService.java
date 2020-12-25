package com.example.erp.services;

import com.example.erp.dao.impl.UserDAOimpl;

public class LoginService
{
    public String login(String username,String password)
    {
        String ans = new UserDAOimpl().login(username,password);
        return ans;
    }
}
