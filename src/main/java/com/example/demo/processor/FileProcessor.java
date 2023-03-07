package com.example.demo.processor;

import com.example.demo.model.Person;

import java.util.List;

public interface FileProcessor {

    public String processFile(List<Person> contents);
}