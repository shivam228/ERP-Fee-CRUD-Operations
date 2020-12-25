package com.example.erp.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
@Table(name ="student_payment")
public class Student_payment
{
    @Id
    @Column(name="id")
    @GeneratedValue(generator = "incrementer")
    @GenericGenerator(name = "incrementer", strategy = "increment")
    private Integer id;

    @Column(name="Description")
    private String desc;
    private int amount;
    private String paymentdate;



    @OneToOne(optional = false)
    @JoinColumn(name = "Bill_id", referencedColumnName = "id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private student stud;


    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

  //  public student getStud() {
  //      return stud;
 //   }

    public void setStud(student stud) {
       this.stud = stud;
   }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(String paymentdate) {
        this.paymentdate = paymentdate;
    }
}