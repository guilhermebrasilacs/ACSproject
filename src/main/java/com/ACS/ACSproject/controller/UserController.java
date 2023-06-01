package com.ACS.ACSproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {
    @GetMapping("/testeACS")
    public String getMensagem(){
        return "Spring boot is working";
    }
}
