package com.example.demo.rs;

import org.springframework.http.ResponseEntity;

public interface AppController {

    public ResponseEntity<String> data(String type);
}
