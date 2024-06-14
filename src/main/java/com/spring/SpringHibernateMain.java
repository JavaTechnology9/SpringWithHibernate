package com.spring;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringHibernateMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
        applicationContext.register(SpringConfiguration.class);
        applicationContext.refresh();
        StudentService studentDao=(StudentService) applicationContext.getBean("studentService");
        Student student=new Student();
        student.setName("Hibernate");
        student.setAddress("Spring");
        student.setEmail("spring@hibernate.com");
        studentDao.saveStudent(student);
    }

}
