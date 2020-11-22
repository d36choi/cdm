package com.producer.cdm.controller;


import com.producer.cdm.model.UberData;
import com.producer.cdm.repository.UberJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.*;

@Slf4j
@Controller
public class KafkaProducerController {

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    HashSet<String> topicList = new HashSet<>(Arrays.asList("car_spec","user_info",
            "user_license","reservation","otp","test"));

    @PostMapping("/publish")
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> post(@RequestParam String topic, @RequestBody Map<String,Object> map)
    {
        HashMap<String,Object> res = new HashMap<>();

        if (!topicList.contains(topic)) {
            res.put("error","wrong topic name");
            log.error("wrong topic name taken");
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        log.info("send... "+map);
        kafkaTemplate.send(topic,map);
//        for( Map.Entry<String, Object> elem : map.entrySet() ){
//            sb.append(elem.getKey());
//            log.info("send... "+elem);
//            kafkaTemplate.send(topic, elem);
//        }
        res.put("topic",topic);
        res.put("Success",map);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }

}
