package com.example.studyvue.service.college;

import com.example.studyvue.entity.College;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollegeService {

    @Cacheable(cacheNames = "findAllCollege")
    List<College> findAll();
    @Cacheable(cacheNames = "findByName",key = "#methodname+#name")
    List<College> findByName(String name);


}



