package com.ashish.demo.rest;


import com.ashish.demo.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number-increment")
public class NumberRestController {

    @Autowired
    private NumberService numberService;

    @GetMapping("/by-one")
    public int increaseNumber() {
        return numberService.incrementNumber();

    }

}



