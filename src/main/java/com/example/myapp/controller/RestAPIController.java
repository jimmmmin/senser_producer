package com.example.myapp.controller;

import com.example.myapp.mongoDB.SensorData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
public class RestAPIController {


    @RequestMapping(value = "/restTest", method = RequestMethod.POST)
    public ResponseEntity<String> restTest(@RequestBody Map<String,Object> map) throws JsonProcessingException {


        System.out.println("정보받음!" );

        System.out.println("내용" + map.get("data"));


         return new ResponseEntity<>("oh yeah~~~~", HttpStatus.CREATED);
    }

}
