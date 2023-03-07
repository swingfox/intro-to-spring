package com.example.demo.processor.impl;

import com.example.demo.model.Person;
import com.example.demo.processor.FileProcessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("jsonProcessor")
@Slf4j
public class JsonProcessor implements FileProcessor {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public String processFile(List<Person> contents) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(contents);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
