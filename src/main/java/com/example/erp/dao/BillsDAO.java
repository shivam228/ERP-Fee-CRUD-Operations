package com.example.erp.dao;

import com.example.erp.bean.Bill;
import com.google.protobuf.Internal;
import java.util.List;
public interface BillsDAO {

    public abstract void addBill(Bill b);

    public abstract void delBill(Integer billId);

    public abstract  Bill getbill(int  billId);

    public  abstract  void updateBillAmt(int billId,int amount);

    public  abstract  void updateBillDate(Integer billId,String date);

    public abstract List<Bill> getAllBill();

}
