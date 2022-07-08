package com.secag.fuf.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingController {
    @Value("${landing.path}")
    String landingPath;

    @GetMapping(value="")
    public String getLanding(){
        return "frontend/index.html";
    }
}
