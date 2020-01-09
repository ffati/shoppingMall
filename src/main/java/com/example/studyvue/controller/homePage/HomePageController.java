package com.example.studyvue.controller.homePage;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class HomePageController {
    @RequestMapping("/page")
    public String homepage(HttpServletRequest httpServletRequest){
        return "index";
    }


}
