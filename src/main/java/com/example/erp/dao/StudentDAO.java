package com.example.erp.dao;
import com.example.erp.bean.student;

import java.util.List;

public interface StudentDAO {

    public abstract void addStudent(student s);

    public abstract List<student> getStudent(String Dept);

    public  abstract List<student> getAllStudents();

    public abstract student getstudent(int id);


}
