package com.example.studyvue.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName SecurityController
 * @Description TODO
 * @Author ff
 * @Date 2020/1/3 21:09
 * @ModifyDate 2020/1/3 21:09
 * @Version 1.0
 */

@Controller
@RequestMapping("/security")
public class SecurityController {

    @RequestMapping("/accessDenied")
    public String accessDenied(){
        return "error/accessDenied";
    }

}
