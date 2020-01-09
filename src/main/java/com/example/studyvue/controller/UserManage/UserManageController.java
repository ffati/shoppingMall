package com.example.studyvue.controller.UserManage;

import com.example.studyvue.entity.UserEntity;
import com.example.studyvue.service.user.UserService;
import com.example.studyvue.util.registerCheck.RegisterCheck;
import com.example.studyvue.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName RegisterController
 * @Description TODO
 * @Author ff
 * @Date 2019/12/21 17:59
 * @ModifyDate 2019/12/21 17:59
 * @Version 1.0
 */

@Controller
@RequestMapping("/userManage")
public class UserManageController {

    @Autowired
    private UserService userService;

    @Autowired
    private RegisterCheck registerCheck;



    @RequestMapping("/newUserPage")
    public String registerPage(){
        return "login/register";
    }



    /**
     * @author: ff
     * @date:
     * @param: [model, user]
     * @return: com.example.studyvue.vo.Message
     */
    @RequestMapping("/registerUser")
    @ResponseBody
    public synchronized Message registerUser(Model model,
                               UserEntity user
                               ){
        Message message= new Message();

        //检测手机号是否重复
        Boolean resultDuplicate= registerCheck.checkPhoneNum(user.getPhonenumber());
        if (resultDuplicate){
            message.setStatusCode("110");
            message.setInformation("手机号已经存在！");
            return message;
        }

        Boolean nameResultDuplicate= registerCheck.checkUserName(user.getUsername());
        if (nameResultDuplicate){
            message.setStatusCode("111");
            message.setInformation("用户名已经存在！");
            return message;
        }

        user.setUsercategory("ROLE_USER");
        user.setUserlevel("1");
        //生成identityId
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMM");
        StringBuffer identityIdString=new StringBuffer(simpleDateFormat.format(new Date()));
        identityIdString=identityIdString.append(user.getSex().toString());
        Integer maxIDInteger=userService.findMaxID();
        if (null==maxIDInteger){
            maxIDInteger=1;
        }
        String maxID=Integer.valueOf(maxIDInteger+1).toString();

        if(maxID.length()==1){
            identityIdString.append("00").append(maxID);
        }else if (maxID.length()==2){
            identityIdString.append("0").append(maxID);
        }else {
            identityIdString.append(maxID);
        }


        user.setIdentityid(identityIdString.toString());
        //密码编码
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String bcryprPassword=passwordEncoder.encode(user.getUserpassword());
        user.setUserpassword(bcryprPassword);
        userService.register(user);

        message.setStatusCode("200");
        message.setInformation("注册成功！");
        return message;
    }


    /**
     * @author: ff
     * @date: 2020/1/9 13:34
     * @param: [userEntity]
     * @return: com.example.studyvue.vo.Message
     * 更新用户信息
     */
    @ResponseBody
    @RequestMapping("/updateUser")
    public Message updateUser(String userCategory,String identityid){

        Message message=new Message();
        if (userCategory==""){
            message.setStatusCode("500");
            message.setInformation("更新失败！");
            return message;
        }

        UserEntity userEntity=new UserEntity();
        userEntity.setIdentityid(identityid);
        userEntity=userService.findByAnyParameter(userEntity);
        userEntity.setUsercategory(userCategory);
        userService.updateUser(userEntity);

        message.setStatusCode("200");
        message.setInformation("更新成功！");
        return message;
    }


}
