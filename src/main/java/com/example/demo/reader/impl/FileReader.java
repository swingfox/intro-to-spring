package com.example.demo.reader.impl;

import com.example.demo.factory.DataTypeFactory;
import com.example.demo.model.Person;
import com.example.demo.processor.FileProcessor;
import com.example.demo.reader.DocumentReader;
import com.example.demo.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@Slf4j
public class FileReader implements DocumentReader {

    DataTypeFactory dataTypeFactory;

    @Autowired
    public FileReader(DataTypeFactory dataTypeFactory) {
        this.dataTypeFactory = dataTypeFactory;
    }

    @Override
    public String read(String type) {
        var personList = Util.getPersonList("personList.csv");
        var processor = dataTypeFactory.getDataType(type);
        return processor.processFile(personList);
    }
}
