package com.example.studyvue.controller.groupBuying;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groupBuying")
public class GroupBuyingController {

    @RequestMapping("/allCommodity")
    public String allCommodity(){

        return "buytoday/buytoday";
    }


}
