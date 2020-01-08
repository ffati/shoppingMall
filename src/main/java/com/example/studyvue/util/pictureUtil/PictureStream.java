package com.example.studyvue.util.pictureUtil;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @ClassName PictureStream
 * @Description TODO
 * @Author ff
 * @Date 2020/1/8 12:40
 * @ModifyDate 2020/1/8 12:40
 * @Version 1.0
 */

@Component
public class PictureStream {

    public static void showPicture(HttpServletResponse httpServletResponse,File file) {

        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
        inputStream = new FileInputStream(file);
        bufferedInputStream = new BufferedInputStream(inputStream);
        outputStream = httpServletResponse.getOutputStream();
        bufferedOutputStream = new BufferedOutputStream(outputStream);

        int index = -1;
        while ((index = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(index);
        }
        bufferedOutputStream.flush();

    } catch(Exception e)

    {
        e.printStackTrace();

    }finally

    {
        try {
            bufferedInputStream.close();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

}
