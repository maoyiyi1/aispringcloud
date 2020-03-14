package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {
    @Autowired
    private RestTemplate restTemplate;

    String url="http://localhost:8010/student";

    @GetMapping("findAll")
    public Collection<Student> findAll(){
        return  restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class).getBody();
    }

    @GetMapping("findAll2")
    public Collection<Student> findAll2(){
        return  restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }

    @GetMapping("findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return restTemplate.getForEntity(url+"/findById/{id}",Student.class,id).getBody();
    }

    @GetMapping("findById2/{id}")
    public Student findById2(@PathVariable("id") long id){
        return restTemplate.getForObject(url+"/findById/{id}",Student.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity(url+"/save",student,null).getBody();
    }

    @PostMapping("/save2")
    public void save2(@RequestBody Student student){
        restTemplate.postForObject(url+"/save",student,null);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put(url+"/update",student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable long id){
        restTemplate.delete(url+"/deleteById/{id}",id);
    }

}
