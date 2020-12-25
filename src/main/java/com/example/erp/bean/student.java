package com.example.erp.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="student_Details")
public class student
{
    @Id
    @Column(name="student_id")
    @GeneratedValue(generator = "incrementer")
    @GenericGenerator(name = "incrementer", strategy = "increment")
    private Integer id;

    @Column(name="Fullname")
    private String name;
    private String Roll_no;
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    @OneToMany(mappedBy = "student")
    private Set<Bill> bill;
    @OneToMany(mappedBy = "stud")
    private Set<Student_payment> pay;

  //  public Set<Bill> getBill() {
  //      return bill;
  //  }

    public void setBill(Set<Bill> bill) {
        this.bill = bill;
    }

  //  public Set<Student_payment> getPay() {
  //      return pay;
  //  }

    public void setPay(Set<Student_payment> pay) {
        this.pay = pay;
    }

    public student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll_no() {
        return Roll_no;
    }

    public void setRoll_no(String roll_no) {
        Roll_no = roll_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

}