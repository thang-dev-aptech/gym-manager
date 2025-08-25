package com.yourcompany.gymmanagement;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Example {

    @GetMapping("/index")
    public String index(){
        return "hello";
    }
}
