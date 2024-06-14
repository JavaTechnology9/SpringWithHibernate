package com.spring;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class StudentDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void saveStudent(Student student){
        sessionFactory.openSession().save(student);
    }
}
