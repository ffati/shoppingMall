package com.example.studyvue.util.common;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName StaticUtil
 * @Description TODO
 * @Author ff
 * @Date 2020/1/8 17:33
 * @ModifyDate 2020/1/8 17:33
 * @Version 1.0
 */

@Component
public class StaticUtil {

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
    public static String pictureDirPath(){

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


}
