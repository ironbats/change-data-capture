package com.cdc.architecture.kafka.consumer;

import com.cdc.architecture.data.ChangeCDC;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;

class KafkaEventConsumerTest {

    private final KafkaEventConsumer consumer = new KafkaEventConsumer();

    @Test
    void consumerLogsPayloadWithoutErrors() {
        ChangeCDC changeCDC = new ChangeCDC();
        ConsumerRecord<String, ChangeCDC> record = new ConsumerRecord<>("stock.ingestion.simdb.lojas", 0, 0L, "key",
                changeCDC);
        consumer.consumer(record);
    }
}
