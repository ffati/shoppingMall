package com.example.studyvue.util.common;

import com.example.studyvue.entity.UserEntity;
import com.example.studyvue.service.user.UserService;
import com.example.studyvue.vo.CurrentUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName CurrentUser
 * @Description TODO
 * @Author ff
 * @Date 2020/1/6 20:38
 * @ModifyDate 2020/1/6 20:38
 * @Version 1.0
 */

@Component
public class CurrentUser {

    @Autowired
    private UserService userService;


public CurrentUserVo currentUser(HttpSession session){

    CurrentUserVo currentUserVon=new CurrentUserVo();
    UserEntity userEntity=new UserEntity();

    SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
    userEntity.setUsername(((UserDetails)securityContext.getAuthentication().getPrincipal()).getUsername());
    userEntity=userService.findByAnyParameter(userEntity);

    currentUserVon.setUsername(userEntity.getUsername());
    currentUserVon.setSex(userEntity.getSex());
    currentUserVon.setIdentityid(userEntity.getIdentityid());
    currentUserVon.setPhonenumber(userEntity.getPhonenumber());
    currentUserVon.setRegistrationTime(userEntity.getRegistrationTime());
    currentUserVon.setUsercategory(userEntity.getUsercategory());
    currentUserVon.setPictureaddress(userEntity.getPictureaddress());
    currentUserVon.setUserlevel(userEntity.getUserlevel());

    return currentUserVon;

}

}
