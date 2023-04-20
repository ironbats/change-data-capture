package com.cdc.architecture.kafka.consumer;


import com.cdc.architecture.data.ChangeCDC;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaEventConsumer {


    @KafkaListener(topics = {"stock.ingestion.simdb.lojas"}, containerFactory = "kafkaListenerContainerFactory")
    public void consumer(ConsumerRecord<String, ChangeCDC> payload) {
        log.info("topic: " + payload.topic() + " key: " + payload.key() + " value:" + payload.value());
    }

}
