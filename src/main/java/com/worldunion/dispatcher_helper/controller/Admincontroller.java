package com.worldunion.dispatcher_helper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/admin")
public class Admincontroller {
    @GetMapping("/login")
    public String login()
    {
        return "/admin/login";
    }


}
