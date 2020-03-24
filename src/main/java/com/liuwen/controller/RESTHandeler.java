package com.liuwen.controller;

import com.liuwen.entity.Student;
import com.liuwen.entity.User;
import com.liuwen.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
@RestController
@RequestMapping("/rest")
public class RESTHandeler {
    @Autowired
    private StudentRepository studentRepository;

//    http://localhost:8080/rest/findAll
    @GetMapping("/findAll")
    public Collection<Student> findAll(HttpServletResponse response){
        response.setContentType("text/json;charset=UTF-8");
        return studentRepository.findAll();
    }
//    http://localhost:8080/rest/findById/{id}
    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return studentRepository.findById(id);
    }

//    http://localhost:8080/rest/save
    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }
//    http://localhost:8080/rest/update
    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }
//    http://localhost:8080/rest/deleteById/{id}
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        studentRepository.deleteById(id);
    }
}