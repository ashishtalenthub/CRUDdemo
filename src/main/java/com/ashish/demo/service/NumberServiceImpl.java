package com.ashish.demo.service;

import com.ashish.demo.dao.NumberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NumberServiceImpl implements NumberService {

    private final NumberDAO numberDAO;

    // customer injection
    @Autowired
    public NumberServiceImpl(NumberDAO theNumberDAO) {
        numberDAO = theNumberDAO;
    }


    @Override
    public synchronized int incrementNumber() {
        int numberInDatabase = numberDAO.getNumber();
        int updatedNumber = numberInDatabase + 1;
        numberDAO.updateNumber(updatedNumber);
        return updatedNumber;

    }
}

