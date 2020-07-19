//package com.producer.cdm.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/kafka/producer")
//public class KafkaProducerController {
//
//    private kafkaTemplate<String, UberModel> kafkaTemplate;
//    private Object UberModel;
//
//    @Autowired
//    public KafkaProducerController(kafkaTemplate<String, UberModel> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//    @PostMapping
//    public void post()
//    {
//        kafkaTemplate.send(TOPICNAME,UberModel);
//    }
//}
