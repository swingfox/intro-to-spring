package com.example.demo.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Person {
    private String name;
    private String gender;

    private int age;

    public Person(String name) {

    }

    public Person(){

    }

    public void person(){
        log.info("Person parent class");

    }
}
