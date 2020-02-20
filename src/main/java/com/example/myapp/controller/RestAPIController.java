package com.example.myapp.controller;

import com.example.myapp.mongoDB.SensorData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class RestAPIController {

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping(value = "/restTest", method = RequestMethod.POST)
    public ResponseEntity<String> restTest(@RequestBody Map<String,Object> map) {


        System.out.println("정보받음!" );

        System.out.println("내용" + map.get("data"));

        ObjectMapper mapper = new ObjectMapper();

        List<Map> temp = (List<Map>) map.get("data");
        Map<String, Object> tmap = temp.get(0);
        System.out.println("성공?"+tmap);

        SensorData last = mapper.convertValue(tmap, SensorData.class);
        System.out.println("변환 성공" + last.tsString());

        long ts = last.getTs();
        Query query = new Query(Criteria.where("ts").lte(ts));
        mongoTemplate.remove(query,"keepData");
        System.out.println("delete data");



         return new ResponseEntity<>("oh yeah~~~~", HttpStatus.CREATED);
    }


    @RequestMapping(value="/resultTest", method = RequestMethod.POST)
    public Mono<String> resultTest(@RequestBody Map<String,Object> map) {

        System.out.println("들어오긴한다...");
        System.out.println(map.get("data"));

        Mono<String> ack = Mono.just("성공이요~");
        return ack;
    }
}
