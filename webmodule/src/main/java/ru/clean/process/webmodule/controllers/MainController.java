package ru.clean.process.webmodule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String index() {
        return "views/html/index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "views/html/login";
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        return "views/html/admin";
    }

}
