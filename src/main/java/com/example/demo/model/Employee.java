package com.example.demo.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Employee extends Person {

    String company;

    String employeeId;

    public Employee(){
        super("Name");
        super.person();
    }

    public void employee() {

    }

    @Override
    public void person(){
        super.person();
    }
}
