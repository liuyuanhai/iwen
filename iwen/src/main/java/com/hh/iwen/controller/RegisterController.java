package com.hh.iwen.controller;

import com.hh.iwen.bean.BaseUser;
import com.hh.iwen.util.PictureHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Value("${user.img.location}")  //获取属性文件里面设置的属性值
    private  String localPath;

    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    String fileDate = sdf.format(new Date());
    private static final String FILESEPRATOR="/";
    private PictureHandler picHandler=new PictureHandler();

    //    上传照片
    public String uploadImage( MultipartFile file){
        String path=localPath;
        String OriginalFilename=file.getOriginalFilename();//获取文件名加后缀
        picHandler.createFile(path);
        if(file!=null) {
            try {
                path=path+fileDate+FILESEPRATOR;
                picHandler.createFile(path);
                String fileName=picHandler.saveImg(file,path);
                String picPath=path+fileName;
                return "" ;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null ;
    }

    @RequestMapping("save")
    public String save(BaseUser user){

        return "1" ;
    }
}
