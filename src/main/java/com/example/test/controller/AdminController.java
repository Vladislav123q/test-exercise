package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

    @GetMapping("/userlist_page")
    public String userListPage(){
        return "userlist_page";
    }

    @GetMapping("/list1")
    public String list1(){
        return "index1";
    }

    @GetMapping("/list2")
    public String list2(){
        return "index2";
    }

    @GetMapping("/list3")
    public String list3(){
        return "index3";
    }

    @GetMapping("/list4")
    public String list4(){
        return "index4";
    }

}
