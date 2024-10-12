package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;
    

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    } 






    //implement save method
    @Override
    @Transactional   //added it since we are performing an update
    public void save(Student theStudent) {
        // TODO Auto-generated method stub
        entityManager.persist(theStudent);
    }






    @Override
    public Student findById(Integer id) {
        // TODO Auto-generated method stub
        return entityManager.find(Student.class,id);
    }






    @Override
    public List<Student> findAll() {
        // TODO Auto-generated method stub

        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);

        //return query results
        return theQuery.getResultList();
    }






    @Override
    public List<Student> findByLastName(String theLastName) {
        // TODO Auto-generated method stub
        

        //cretae query 
        TypedQuery<Student> theQuery =  entityManager.createQuery("From Student where lastName=:theData",Student.class);

        //set parameters 
        theQuery.setParameter("theData", theLastName);

        //return results
        return theQuery.getResultList();
    }






    @Override
    @Transactional   //=> to perform actual updates on db
    public void update(Student theStudent) {
        // TODO Auto-generated method stub
        entityManager.merge(theStudent);
        
    }






    @Override
    @Transactional
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        
        //retrieve the student 
        Student theStudent = entityManager.find(Student.class, id);

        //delete the student
        entityManager.remove(theStudent);
    }






    @Override
    @Transactional
    public int deleteAll() {
        // TODO Auto-generated method stub
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }

    
    

}
