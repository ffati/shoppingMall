package com.example.studyvue.util.common;

import com.example.studyvue.util.pictureUtil.PictureStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.ContextLoader;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @ClassName pictureStream
 * @Description TODO
 * @Author ff
 * @Date 2020/1/7 16:54
 * @ModifyDate 2020/1/7 16:54
 * @Version 1.0
 */

@Component
public class HeadSculptureStream {

    private static String IMG_DEFAULTIMGPATH;


     static{

        String filePath= null;
        File filedir=null;
        String fileDirPath=null;

        try {
            filePath = new File("").getCanonicalPath();
            System.out.println(filePath);
            filePath=filePath.substring(0,filePath.lastIndexOf("\\"));
            fileDirPath=filePath+"\\shoppingMallImg\\img\\headSculpture";
            filedir=new File(fileDirPath);

            if (!filedir.exists()){
                filedir.mkdirs();
            }
        } catch (IOException e) {

        }
    }

    //头像路径
    private static String makeDirPath(){

        String filePath= null;
        String fileDirPath=null;

        try {
            filePath = new File("").getCanonicalPath();
            System.out.println(filePath);
            filePath=filePath.substring(0,filePath.lastIndexOf("\\"));
            fileDirPath=filePath+"\\shoppingMallImg\\img\\headSculpture";

        } catch (IOException e) {

        }
        return fileDirPath;
    }

    /**
     * @author: ff
     * @date: 2020/1/8 12:51
     * @param: [httpServletResponse, pictureName]
     * @return: void
     */
    public void pictureStream(HttpServletResponse httpServletResponse, String pictureName){

        File file=null;

        System.out.println(System.getProperty("user.dir"));

        try {

            file=new File(makeDirPath()+"\\"+pictureName);
            if (!file.exists()){
                file=ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+IMG_DEFAULTIMGPATH);
            }

            PictureStream.showPicture(httpServletResponse,file);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public  String getImgDefaultimgpath() {
        return IMG_DEFAULTIMGPATH;
    }

    @Value("${defaultHeadSculpture}")
    public  void setImgDefaultimgpath(String imgDefaultimgpath) {
        IMG_DEFAULTIMGPATH = imgDefaultimgpath;
    }
}
