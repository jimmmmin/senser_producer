package com.example.myapp.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController implements ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        return "index.html";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
