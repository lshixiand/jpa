package com.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lidu on 2017/8/12.
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello" ;
    }

    @GetMapping("/")
    public String home(){
        return "home" ;
    }
}