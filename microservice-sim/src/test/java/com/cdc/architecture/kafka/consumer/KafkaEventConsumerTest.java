package com.cdc.architecture.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;

class KafkaEventConsumerTest {

    private final KafkaEventConsumer consumer = new KafkaEventConsumer();

    @Test
    void consumerLogsPayloadWithoutErrors() {
        ConsumerRecord<String, String> record = new ConsumerRecord<>("stock.consolidate", 0, 0L, "key", "value");
        consumer.consumer(record);
    }
}
