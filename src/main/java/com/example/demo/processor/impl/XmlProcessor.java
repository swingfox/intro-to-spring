package com.example.demo.processor.impl;

import com.example.demo.model.Person;
import com.example.demo.model.Persons;
import com.example.demo.processor.FileProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

@Component
@Slf4j
public class XmlProcessor implements FileProcessor {
    @Override
    public String processFile(List<Person> contents) {
        var persons = new Persons();
        persons.setPerson(contents);
        var sw = new StringWriter();
        JAXB.marshal(persons,sw);
        return sw.toString();}
}
