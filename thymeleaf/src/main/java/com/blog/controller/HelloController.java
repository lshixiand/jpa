package com.blog.controller;

import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/test/{id1}/{id2}/{id3}")
    public String test(@PathVariable("id1") String id1, @PathVariable("id2") String id2, @PathVariable("id3") String id3){
        String res = "test ";
        if (id1!=null){
            res+=id1;
        }
        if (id2!=null){
            res+=" " +id2;
        }
        if (id3!=null){
            res+=" " +id3;
        }
        return res ;
    }

    @RequestMapping("/test/{id1}/{id2}")
    public String test(@PathVariable("id1") String id1, @PathVariable("id2") String id2){
        String res = "test ";
        if (id1!=null){
            res+=id1;
        }
        if (id2!=null){
            res+=" " +id2;
        }
        return res ;
    }
}