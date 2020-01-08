package com.example.studyvue.controller.shopCart;

import com.example.studyvue.util.common.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shopCart")
public class ShopCartController {

@Autowired
    private CurrentUser currentUser;

    @RequestMapping("/addCommodity")
    public String addCommodity(HttpSession session){

        return "shopcart/shopcart";
    }

}
