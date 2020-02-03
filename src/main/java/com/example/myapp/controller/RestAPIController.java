package com.example.myapp.controller;

import com.example.myapp.mongoDB.SensorData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Mmap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class RestAPIController {


    @RequestMapping(value = "/restTest", method = RequestMethod.POST)
    public ResponseEntity<String> restTest(@RequestBody Map<String,Object> map) throws JsonProcessingException {


        System.out.println("정보받음!" );

        System.out.println("내용" + map.get("data"));

        ObjectMapper mapper = new ObjectMapper();


        List<Map> temp = (List<Map>) map.get("data");
        Map<String, Object> tmap = temp.get(0);
        System.out.println("성공?"+tmap);

        SensorData last = mapper.convertValue(tmap, SensorData.class);
        System.out.println("변환 성공" + last.tsString());


         return new ResponseEntity<>("oh yeah~~~~", HttpStatus.CREATED);
    }

}
