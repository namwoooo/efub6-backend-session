package com.practice.efubaccount.controller;

import com.practice.efubaccount.dto.ExampleDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HttpExampleController {

    @GetMapping
    public String hello(@RequestParam("name") String name){
    }

    @GetMapping("/obj")
    public ExampleDto hello(@RequestParam("name") String name,
                            @RequestParam("id") Long id,
                            @RequestParam("password") String password) {

    }
}