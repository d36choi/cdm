package com.producer.cdm.controller;


import com.producer.cdm.model.UberData;
import com.producer.cdm.repository.UberJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@Controller
public class KafkaProducerController {

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;
    @Autowired
    UberJpaRepository uberJpaRepository;

    private int id = 1;
    private static final String TOPICNAME = "cdm-test";

    @GetMapping("/publish")
    public String post()
    {
        String return_msg = "data"+id+" is published";
        kafkaTemplate.send(TOPICNAME, uberJpaRepository.findAll().get(id++));
        return return_msg;
    }
}
