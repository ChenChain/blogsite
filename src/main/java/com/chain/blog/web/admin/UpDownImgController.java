package com.chain.blog.web.admin;

import com.chain.blog.utils.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理markdown文本中的图片上传
 *
 * @author: chain
 * @create: 2020/03/04
 **/
@RequestMapping("/admin")
@Controller
public class UpDownImgController {

    @Value("${imgPath}")
    private String path;    //本地保存的路径
    @Value("${imgPathUrl}")
    private String pathURL; //返回的url路径

    @ResponseBody
    @PostMapping("/attach/uploadfile")
    public String imgUpload(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(name = "editormd-image-file", required = true) MultipartFile file) {
        String trueFileName = file.getOriginalFilename();
        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));
        String fileName = "";
        String response_url = "";
        try {
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            fileName = "date_" + DateUtil.dateFormat(new Date(), "yyyy-MM-dd") +"_"+
                    System.currentTimeMillis() + suffix;

            File filePath = new File(path);
            if (!filePath.exists())
                filePath.mkdirs();
            System.out.println(filePath.getAbsolutePath());
            //保存到图片存储路径
            File f = new File(path + fileName);
            file.transferTo(f);
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getName());


            StringBuilder stringBuilder = new StringBuilder(pathURL);
            stringBuilder.append(f.getName());
            response_url = "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"" + stringBuilder.toString() + "\"}";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String u="https://unsplash.it/1000/400?image=1005";
        return response_url;
    }

}
