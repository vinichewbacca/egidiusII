package com.wokieDev.egidiusII.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String olaMundo(){
        return "<h1>Ola Mundo Estranho!!!</h1>";
    }
}
