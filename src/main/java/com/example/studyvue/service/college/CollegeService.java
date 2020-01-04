package com.example.studyvue.service.college;

import com.example.studyvue.entity.College;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollegeService {

    List<College> findAll();

    List<College> findByName(String name);


}



