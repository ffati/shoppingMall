package com.example.studyvue.controller.personalHomepage;

import com.example.studyvue.entity.UserEntity;
import com.example.studyvue.service.user.UserService;
import com.example.studyvue.util.common.CurrentUser;
import com.example.studyvue.util.pictureUtil.HeadSculptureStream;
import com.example.studyvue.util.common.StaticUtil;
import com.example.studyvue.util.pictureUtil.PictureStream;
import com.example.studyvue.vo.CurrentUserVo;
import com.example.studyvue.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName PersonalHomepageController
 * @Description TODO
 * @Author ff
 * @Date 2020/1/7 12:33
 * @ModifyDate 2020/1/7 12:33
 * @Version 1.0
 */

@Controller
@RequestMapping("/personalHomepage")
public class PersonalHomepageController {

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private HeadSculptureStream pictureStream;

    @Autowired
    private UserService userService;

    @RequestMapping("/homepage")
    public String personalHomepage(HttpServletRequest httpServletRequest,
                                   HttpSession session,
                                   Model model){

        CurrentUserVo currentUserVo= currentUser.currentUser(session);
        model.addAttribute("CurrentUserVo",currentUserVo);
        return "personalHomepage/personalHomepage";
    }

/**
 * @author: ff
 * @date: 2020/1/8 15:44
 * @param: [httpServletResponse, pictureName]
 * @return: void
 * 显示头像
 */
    @RequestMapping("/showHeadSculpture")
    public void showHeadSculpture(HttpServletResponse httpServletResponse,
                                  String pictureName){

        pictureStream.pictureStream(httpServletResponse,pictureName);
    }



    /**
     * @author: ff
     * @date: 2020/1/8 20:12
     * @param: [httpServletRequest, id, file]
     * @return: com.example.studyvue.vo.Message
     * 处理上传头像并更新库
     */
    @ResponseBody
    @RequestMapping(value = "/uploadHeadSculpture",method = RequestMethod.POST)
    public Message uploadHeadSculpture(HttpServletRequest httpServletRequest,
                                    @RequestParam("id") String id,
                                    @RequestParam(value = "file",required = true) MultipartFile file){
        //String realPath=session.getServletContext().getRealPath("/upload");

        System.out.println(httpServletRequest.getServletContext().getRealPath(""));
        Message message=new Message();
        String picturePath=StaticUtil.pictureDirPath();

        int pointIndex=file.getOriginalFilename().lastIndexOf(".");
        int nameLength=file.getOriginalFilename().length();
        String fileName=id+file.getOriginalFilename().substring(pointIndex,nameLength);

        Boolean decision= PictureStream.wrightPicture(picturePath,fileName,file);

        if (!decision){
            message.setInformation("上传失败");
            message.setStatusCode("403");
            return message;
        }else {
            UserEntity userEntity=new UserEntity();
            userEntity.setIdentityid(id);
            userEntity=userService.findByAnyParameter(userEntity);
            userEntity.setPictureaddress(fileName);
            userService.updateUser(userEntity);

            message.setInformation("上传成功");
            message.setStatusCode("200");
        }

        return message;
    }

    /**
     * @author: ff
     * @date: 2020/1/9 15:17
     * @param: [httpServletRequest, session, model]
     * @return: java.lang.String
     *
     * 个人主页修改权限页面
     */
    @RequestMapping("/updateUserPage")
    public String updateUserPage(HttpServletRequest httpServletRequest,
                                   HttpSession session,
                                   Model model){

        CurrentUserVo currentUserVo= currentUser.currentUser(session);

        model.addAttribute("identityid",currentUserVo.getIdentityid());

        return "personalHomepage/updateRole";
    }


}
