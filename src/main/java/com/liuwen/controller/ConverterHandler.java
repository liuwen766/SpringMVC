package com.liuwen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
@RestController
@RequestMapping("/converter")
public class ConverterHandler {
//    http://localhost:8080/addDate.jsp
    @RequestMapping("/date")
    public String date(Date date){
        return date.toString();
    }
}