package com.example.studyvue.repository.college;

import com.example.studyvue.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeDao extends JpaRepository<College,Long> {

    College findByNameIsLike(String name);

}
