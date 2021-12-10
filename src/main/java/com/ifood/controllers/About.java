package com.ifood.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/about")
public class About {

    @GetMapping
    public String getAbout() {
        return "Hello World!";
    }
}
