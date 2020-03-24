package com.liuwen.controller;
import com.liuwen.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloHandler {
//    http://localhost:8080/hello/index?name=zhangsan&id=10
    @RequestMapping(value = "/index",method = RequestMethod.GET,params = {"name","id"})
    public String index(String name,int id){
        System.out.println(name+" "+id);
        System.out.println("执?行?了?index...");
        return "index";
    }
//    http://localhost:8080/hello/rest/张三/10
    @RequestMapping("/rest/{name}/{id}")
    public String rest(@PathVariable("name") String name, @PathVariable("id") int id){
        System.out.println(name);
        System.out.println(id);
        return "index";
    }
//    http://localhost:8080/hello/cookie
    @RequestMapping("/cookie")
    public String cookie(@CookieValue(value = "JSESSIONID") String sessionId){
        System.out.println(sessionId);
        return "index";
    }
//    http://localhost:8080/register.jsp
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(User user){
        System.out.println(user);
        return "index";
    }
//    http://localhost:8080/hello/forward
    @RequestMapping("/forward")
    public String forward(){
        return "forward:/index.jsp";
// return "index";
    }

//    http://localhost:8080/hello/redirect
    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:/index.jsp";
    }
}