package com.producer.cdm.controller;


import com.producer.cdm.model.UberData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class KafkaProducerController {

//    private kafkaTemplate<String, UberData> kafkaTemplate;
//    private Object UberData;
//
//    @Autowired
//    public KafkaProducerController(kafkaTemplate<String, UberData> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//    @PostMapping
//    public void post()
//    {
//        kafkaTemplate.send(TOPICNAME, UberData);
//    }
}
