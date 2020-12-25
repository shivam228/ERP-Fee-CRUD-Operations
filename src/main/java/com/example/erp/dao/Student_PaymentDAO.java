package com.example.erp.dao;

import com.example.erp.bean.Student_payment;

import java.util.List;

public interface Student_PaymentDAO {

    public abstract List<Student_payment> getPayment();

    public abstract void addPayment(Student_payment s);

    public abstract void delBills(Integer billId);



}
