package com.liuwen.controller;

import com.liuwen.entity.User;
import com.liuwen.entity.UserList;
import com.liuwen.entity.UserMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

//@Controller
@RestController /*类上添加该注解，方法中就可以不写 @ResponseBody*/
@RequestMapping("/data")
public class DataBindHandler {

//    http://localhost:8080/data/baseType?id=1
    @RequestMapping("/baseType")
//    @ResponseBody
    public String baseType(int id){
        return id+"";
    }

//    http://localhost:8080/data/packageType
//    http://localhost:8080/data/packageType?num=101
    @RequestMapping("/packageType")
//    @ResponseBody
    public String packageType(@RequestParam(value = "num",required = false,defaultValue = "0") Integer id){
        return id+"";
    }
//   http://localhost:8080/data/array?name=zhangsan&name=lisi&name=wangwu
    @RequestMapping("/array")
//    @ResponseBody
    public String array(String[] name){
        String str = Arrays.toString(name);
        return str;
    }
//    http://localhost:8080/addList.jsp
    @RequestMapping("/list")
//    @ResponseBody
    public String list(UserList userList){
        StringBuffer str = new StringBuffer();
        for(User user:userList.getUsers()){
            str.append(user);
        }
        return str.toString();
    }
    //    http://localhost:8080/addMap.jsp
    @RequestMapping("/map")
    public String map(UserMap userMap){
        StringBuffer str = new StringBuffer();
        for(String key:userMap.getUsers().keySet()){
            User user = userMap.getUsers().get(key);
            str.append(user);
        }
        return str.toString();
    }

//    http://localhost:8080/json.jsp
    @RequestMapping("/json")
    public User json(@RequestBody User user){
        System.out.println(user);
        user.setId(6);
        user.setName("张六");
        return user;
    }

}
