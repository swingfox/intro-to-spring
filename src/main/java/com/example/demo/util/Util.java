package com.example.demo.util;

import com.example.demo.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Util {
    public static List<Person> getPersonList(String fileName) {
        List<Person> personList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Person p = new Person();
                p.setName(values[0]);
                p.setGender(values[1]);
                p.setAge(Integer.parseInt(values[2]));
                personList.add(p);
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return personList;
    }

    public static List<Person> getPersonList(String fileName, String delimiter) {
        List<Person> personList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                Person p = new Person();
                p.setName(values[0]);
                p.setGender(values[1]);
                p.setAge(Integer.parseInt(values[2]));
                personList.add(p);
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return personList;
    }
}
