package com.example.erp.services;

import com.example.erp.bean.Bill;
import com.example.erp.bean.Student_payment;
import com.example.erp.bean.student;
import com.example.erp.dao.impl.BillsDAOimpl;
import com.example.erp.dao.impl.StudentDAOimpl;
import com.example.erp.dao.impl.Student_paymentDAOimpl;
//import sun.jvm.hotspot.types.CIntegerField;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BillsService {

    public void addBillToStudent( Integer Amount , String billDate, String Deadline , String Desc, student Stu )
    {
        Bill bill1 = new Bill();

        bill1.setName(Desc);
        bill1.setamount(Amount);
        bill1.setBilldate(billDate);
        bill1.setDeadline(Deadline);
        bill1.setStudent(Stu);

        new BillsDAOimpl().addBill(bill1);

    }

    public void updateBill1(Integer billId,Integer amount)
    {

        new BillsDAOimpl().updateBillAmt(billId,amount);

    }

    public void updateBill2(Integer billId,String date)
    {

        new BillsDAOimpl().updateBillDate(billId,date);

    }


    public void addBillToDept(Integer Amount , String billDate, String Deadline , String Desc, String Dept)
    {

        List<student> SameDeptStudents;

        StudentDAOimpl students = new StudentDAOimpl();

        SameDeptStudents = students.getStudent(Dept);

        for(student s : SameDeptStudents)
        {

            Bill bill1 = new Bill();

            bill1.setName(Desc);
            bill1.setamount(Amount);
            bill1.setBilldate(billDate);
            bill1.setDeadline(Deadline);
            bill1.setStudent(s);

            new BillsDAOimpl().addBill(bill1);

        }


    }

    public List<Student_payment> billPaidView()
    {

        List<Student_payment> allPaidStudents ;

        allPaidStudents = new Student_paymentDAOimpl().getPayment();

        return allPaidStudents;

    }

    public Set<student> billNotPaidView_by_students()
    {

        List<Bill> bills_with_stu = new BillsDAOimpl().getAllBill();

        List<Student_payment> allPaidStudents ;

        allPaidStudents = new Student_paymentDAOimpl().getPayment();

        Set<Integer> paidBillId = new HashSet<>();

        for(Student_payment s : allPaidStudents){
            paidBillId.add(s.getBill().getId());
        }

        Set<student> UnpaidStudents = new HashSet<>();

        for(Bill b : bills_with_stu){

            if(paidBillId.contains(b.getId())){
                ;
            }else{
                UnpaidStudents.add(b.getStudent());
            }

        }


        return UnpaidStudents;
    }

    public Set<Bill> billNotPaidView_by_billid()
    {

        List<Bill> bills_with_stu = new BillsDAOimpl().getAllBill();

        List<Student_payment> allPaidStudents ;

        allPaidStudents = new Student_paymentDAOimpl().getPayment();

        Set<Integer> paidBillId = new HashSet<>();

        for(Student_payment s : allPaidStudents){
            paidBillId.add(s.getBill().getId());
        }

        Set<Bill> UnpaidBills = new HashSet<>();

        for(Bill b : bills_with_stu){

            if(paidBillId.contains(b.getId())){
                ;
            }else{
                UnpaidBills.add(b);
            }

        }


        return UnpaidBills;
    }


    public Bill billViewByID(int billId)
    {

       Bill b  = new BillsDAOimpl().getbill(billId);
        return b;

    }

    public void deleteBill(Integer BillId)
    {
        new BillsDAOimpl().delBill(BillId);
        new Student_paymentDAOimpl().delBills(BillId);

    }

    public student getstudentbyid(int bid) {
        student s = new StudentDAOimpl().getstudent(bid);
        return s;
    }

}
