package com.example.demo.factory;

import com.example.demo.processor.FileProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DataTypeFactory {

    ApplicationContext context;

    public DataTypeFactory(ApplicationContext context){
        this.context = context;
    }

    public FileProcessor getDataType(String type) {
        var processor = context.getBean("jsonProcessor", FileProcessor.class);

        switch (type.toLowerCase()) {
            case "xml":
                processor = context.getBean("xmlProcessor", FileProcessor.class);
                break;
        }

        return processor;
    }
}
