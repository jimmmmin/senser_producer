package com.example.myapp.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public HashMap hello() {
        HashMap result = new HashMap();
        result.put("message", "안녕하세요");
        return result;
    }

    @PostMapping("/ip")
    public ResponseEntity<String> ip (HttpServletRequest request) {
        return ResponseEntity.ok(request.getRemoteAddr());
    }
}

