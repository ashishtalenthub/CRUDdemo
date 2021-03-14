package com.ashish.demo.dao;

import com.ashish.demo.entity.MyNumber;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class NumberDAOHibernateImpl implements NumberDAO {

    // define field for entity manager

    private final EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public NumberDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public int getNumber() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<MyNumber> theQuery =
                currentSession.createQuery("from MyNumber", MyNumber.class);

        // execute query and get result
        List<MyNumber> numbers = theQuery.getResultList();


        // return the result
        return numbers.get(0).getValue();
    }


    @Override
    @Transactional
    public void updateNumber(int theNumber) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<MyNumber> theQuery =
                currentSession.createQuery("from MyNumber", MyNumber.class);

        // execute query and get result
        List<MyNumber> numbers = theQuery.getResultList();


        // return the result
        numbers.get(0).setValue(theNumber);
        currentSession.saveOrUpdate(numbers.get(0));


    }
}



