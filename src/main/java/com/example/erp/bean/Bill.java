package com.example.erp.bean;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name ="bills")
public class Bill {
    @Id
    @Column(name="id")
    @GeneratedValue(generator = "incrementer")
    @GenericGenerator(name = "incrementer", strategy = "increment")
    private Integer id;

    @Column(name="Description")
    private String name;
    private int amount;

    public student getStudent() {
        return student;
    }

    public void setStudent(student student) {
        this.student = student;
    }

    //public Student_payment getSta() {
   //     return sta;
   // }

    public void setSta(Student_payment sta) {
        this.sta = sta;
    }

    private String billdate;
    private String deadline;



    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private student student;

    @OneToOne(mappedBy = "bill")
    private Student_payment sta;

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBilldate() {
        return billdate;
    }

    public int getamount() {
        return amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}