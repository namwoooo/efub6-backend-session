package com.practice.efubaccount.controller;

import com.practice.efubaccount.dto.ExampleDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HttpExampleController {

    @GetMapping
    @ResponseBody // http의 Response Body에 아래 데이터를 바로 넣겠다는 의미
    public String hello(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("/obj")
    @ResponseBody
    public ExampleDto hello(@RequestParam("name") String name,
                            @RequestParam("id") Long id,
                            @RequestParam("password") String password) {
        ExampleDto exampleDto = new ExampleDto();

        exampleDto.setName(name);
        exampleDto.setId(id);
        exampleDto.setPassword(password);

        return exampleDto;
    }
}