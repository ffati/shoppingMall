package com.example.studyvue.service.college.collegeImpl;

import com.example.studyvue.entity.College;
import com.example.studyvue.repository.college.CollegeDao;
import com.example.studyvue.service.college.CollegeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeDao collegeDao;

    @Override
    public List<College> findAll() {
        return collegeDao.findAll();
    }

    @Override
    public List<College> findByName(String name) {
        College college=new College();
        college.setName(name);
        //ExampleMatcher matcher = ExampleMatcher.matchingAny();
        Example<College> example=Example.of(college);
/*       Optional<College> optionalCollege= collegeDao.findOne(example);
        return optionalCollege.get();*/
    //return collegeDao.findByNameIsLike(name);

        List<College> collegeList=collegeDao.findAll(example);
        return collegeList;

    }
}
