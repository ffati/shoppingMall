package com.example.studyvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class StudyvueApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyvueApplication.class, args);
    }

}
