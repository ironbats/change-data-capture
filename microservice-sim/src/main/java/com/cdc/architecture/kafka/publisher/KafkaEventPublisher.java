package com.cdc.architecture.kafka.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
public class KafkaEventPublisher  {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private final String topicName = "stock.consolidate";


    public void publishEvent(String message) {

        log.info("Sent kafka message..."  + message);

        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(topicName,KafkaEventPublisher.class.getName(), message);

        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
