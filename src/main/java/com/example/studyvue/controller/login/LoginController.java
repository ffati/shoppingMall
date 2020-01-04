package com.example.studyvue.controller.login;

import com.example.studyvue.vo.Message;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping(value = "/login",method = RequestMethod.GET)
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @GetMapping("/loginError")
    @ResponseBody
    public Message loginError(HttpServletRequest httpServletRequest){

        AuthenticationException authenticationException = (AuthenticationException) httpServletRequest.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        Message message=new Message();

        message.setStatusCode("477");
        if (authenticationException instanceof UsernameNotFoundException || authenticationException instanceof BadCredentialsException) {
            message.setInformation("用户名或密码错误");
        } else if (authenticationException instanceof DisabledException) {
            message.setInformation("用户已被禁用");
        } else if (authenticationException instanceof LockedException) {
            message.setInformation("账户被锁定");
        } else if (authenticationException instanceof AccountExpiredException) {
            message.setInformation("账户过期");
        } else if (authenticationException instanceof CredentialsExpiredException) {
            message.setInformation("证书过期");
        } else {
            message.setInformation("登录失败");
        }

        return message;

    }

}
