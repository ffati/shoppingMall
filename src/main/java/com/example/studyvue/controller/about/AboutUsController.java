package com.example.studyvue.controller.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("aboutUs")
public class AboutUsController {


    @RequestMapping("usInformation")
    public String allCommodity(){

        return "about/about";
    }


}
