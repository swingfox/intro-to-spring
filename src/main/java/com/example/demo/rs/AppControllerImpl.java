package com.example.demo.rs;

import com.example.demo.model.Person;
import com.example.demo.reader.DocumentReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AppControllerImpl implements AppController{

    DocumentReader fileReader;

    @Autowired
    public AppControllerImpl(DocumentReader fileReader) {
        this.fileReader = fileReader;
    }

    @RequestMapping("/data")
    public ResponseEntity<String> data(@RequestParam("type") String type) {
        var data = fileReader.read(type);
        var headers = new HttpHeaders();
        headers.add("Content-Type", String.format("application/%s; charset=UTF-8",type));
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
