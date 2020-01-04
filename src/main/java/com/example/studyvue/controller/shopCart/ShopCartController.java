package com.example.studyvue.controller.shopCart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopCart")
public class ShopCartController {

    @RequestMapping("/addCommodity")
    public String addCommodity(){
        //throw new NullPointerException();
        return "shopcart/shopcart";
    }

}
