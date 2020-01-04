package com.example.studyvue.controller.collegeController;


import com.example.studyvue.service.college.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/College")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

/**
 * @author: ff
 * @date: 2019/12/2 21:09  
 * @param: [model]
 * @return: java.lang.String
 */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("college",collegeService.findAll());
        return "College";
    }


/*
 * @author: ff
 * @date: 2019/12/2 23:38
 * @param: [model]
 * @return: java.lang.String
 */
    @RequestMapping("/findOneByName/{name}")
    public String findCollegeByName(Model model,
                                    @PathVariable("name") String name){
        model.addAttribute("college",collegeService.findByName(name));
        return "College";
    }

}
