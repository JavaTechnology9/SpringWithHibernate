package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

public class StudentService {
    @Autowired
    private StudentDao studentDao;

    private TransactionTemplate transactionTemplate;

    public void setTransactionManager(PlatformTransactionManager transactionManager){
        this.transactionTemplate=new TransactionTemplate(transactionManager);
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void saveStudent(Student student){
        studentDao.saveStudent(student);
        /*this.transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                studentDao.saveStudent(student);

            }
        });*/

    }
}
