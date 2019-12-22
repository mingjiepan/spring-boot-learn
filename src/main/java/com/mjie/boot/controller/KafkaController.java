package com.mjie.boot.controller;

import com.mjie.boot.kafka.KafkaMessage;
import com.mjie.boot.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

//@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/sendKafkaMessage")
    public KafkaMessage sendKafkaMessage(@RequestParam(name = "id") long id,
                                         @RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setId(id);
        kafkaMessage.setUsername(username);
        kafkaMessage.setPassword(password);

        kafkaMessage.setBirthday(new Date());

        kafkaProducer.sendKafkaMessage(kafkaMessage);

        return kafkaMessage;
    }
}
