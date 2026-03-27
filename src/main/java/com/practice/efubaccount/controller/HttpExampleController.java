package com.practice.efubaccount.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HttpExampleController {

    @GetMapping
    @ResponseBody // http의 Response Body에 아래 데이터를 바로 넣겠다는 의미
    public String hello(@RequestParam("name") String name){
        return "hello" + name;
    }

}