package com.example.studyvue.controller.commodity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commodity")
public class CommodityController {


    @RequestMapping("/allCommodity")
    public String login(){

        return "commodity/commodity";
    }

}
