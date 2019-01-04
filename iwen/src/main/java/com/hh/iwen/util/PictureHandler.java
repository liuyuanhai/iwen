package com.hh.iwen.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class PictureHandler {
	
	public  String saveImg(MultipartFile multipartFile,String path) throws IOException {
		 String OriginalFilename=multipartFile.getOriginalFilename();//获取文件名加后缀
		 String fileF = OriginalFilename.substring(OriginalFilename.lastIndexOf("."), OriginalFilename.length());//文件后缀
       FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
       String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
       String fileName = uuid + fileF;
       BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + fileName));
       byte[] bs = new byte[1024];
       int len;
       while ((len = fileInputStream.read(bs)) != -1) {
           bos.write(bs, 0, len);
       }
       bos.flush();
       bos.close();
       return fileName;
   }

	public void createFile(String path) {
		File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
	}
	
	public  void deleteFiles(String path) {
		File file=new File(path);
		file.delete();
	}
	
	//判断图片路径是否正确
	public boolean valadateUrl(String source) {  
        try {  
            URL url = new URL(source);
            URLConnection uc = url.openConnection();
            InputStream in = uc.getInputStream();
            if (source.equalsIgnoreCase(uc.getURL().toString())) 
            in.close();  
            return true;  
        } catch (Exception e) {  
            return false;  
        }  
	}

}
