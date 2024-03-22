package com.lms.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {

        return "home";
    }

    // add a request mapping for /leaders

    // add request mapping for /systems



}