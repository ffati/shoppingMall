package com.example.studyvue.controller.consultation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consultation")
public class ConsultationController {

    @RequestMapping("/information")
    public String allCommodity(){

        return "information/information";
    }

}
