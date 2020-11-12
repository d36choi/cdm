package com.producer.cdm.controller;


import com.producer.cdm.model.UberData;
import com.producer.cdm.repository.UberJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
@Controller
public class KafkaProducerController {

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    private static final String TOPICNAME = "test";

    @RequestMapping("/publish")
    @ResponseBody
    public HashMap<String, Object> post(@RequestBody Map<String,Object> map)
    {
        HashMap<String,Object> res = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for( Map.Entry<String, Object> elem : map.entrySet() ){
            sb.append(elem.getKey());
            log.info("send... "+elem);
            kafkaTemplate.send(TOPICNAME, elem);
        }
        res.put("Success",map);
        return res;
    }
}
