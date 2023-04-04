package com.cdc.architecture.kafka.consumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaEventConsumer {

    private final String topicName = "stock.consolidate";

    @KafkaListener(topics = {"stock.consolidate","simdb.simdb.lojas"}, containerFactory = "kafkaListenerContainerFactory")
    public void consumer(ConsumerRecord<String, String> payload) {

        log.info("topic: " + payload.topic() + " key: " + payload.key()  + " value:" + payload.value());

    }

}
