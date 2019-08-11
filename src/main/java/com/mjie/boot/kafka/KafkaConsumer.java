package com.mjie.boot.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"myTopic"}, groupId = "myGroup")
    public void receiveMessage(ConsumerRecord<String, String> consumerRecord) {

        System.out.println("receive message");

        String topic = consumerRecord.topic();
        int partition = consumerRecord.partition();
        long offset = consumerRecord.offset();
        String key = consumerRecord.key();
        String value = consumerRecord.value();
        long timestamp = consumerRecord.timestamp();

        System.out.println("topic =" + topic + ", partition =" + partition + ", offset = " + offset
        + ", key = " + key + ", value = " + value + ", timestamp = " + timestamp);
    }
}
