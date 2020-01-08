package com.example.studyvue.controller.personalHomepage;

import com.example.studyvue.util.common.CurrentUser;
import com.example.studyvue.util.common.HeadSculptureStream;
import com.example.studyvue.vo.CurrentUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/homepage")
    public String personalHomepage(HttpSession session,
                                   Model model){

        CurrentUserVo currentUserVo= currentUser.currentUser(session);

        model.addAttribute("CurrentUserVo",currentUserVo);
        return "personalHomepage/personalHomepage";
    }


    @RequestMapping("/showHeadSculpture")
    public void showHeadSculpture(HttpServletResponse httpServletResponse,
                                  String pictureName){

        pictureStream.pictureStream(httpServletResponse,pictureName);
    }


}
