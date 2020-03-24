package com.liuwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileHandler {
//    http://localhost:8080/upload.jsp
    @PostMapping("/upload")
    public String upload(MultipartFile img, HttpServletRequest request){
        if(img.getSize()>0){
//获取保存上传⽂文件的file路路径
            String path = request.getServletContext().getRealPath("file");
//获取上传的⽂文件名
            String name = img.getOriginalFilename();
            File file = new File(path,name);
            try {
                img.transferTo(file);
//保存上传之后的⽂文件路路径
                request.setAttribute("path","/file/"+name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }
    //    http://localhost:8080/uploads.jsp
    @PostMapping("/uploads")
    public String uploads(MultipartFile[] imgs,HttpServletRequest request){
        List<String> files = new ArrayList<String>();
        for (MultipartFile img:imgs){
            if(img.getSize()>0){
                //获取保存上传⽂文件的file路路径
                String path = request.getServletContext().getRealPath("file");
//获取上传的⽂文件名
                String name = img.getOriginalFilename();
                File file = new File(path,name);
                try {
                    img.transferTo(file);
//保存上传之后的⽂文件路路径
                    files.add("/file/"+name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("files",files);
        return "uploads";

    }
}
