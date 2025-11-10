package com.cdc.architecture.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

class KafkaConsumerConfigTest {

    private final KafkaConsumerConfig config = new KafkaConsumerConfig();

    @Test
    void consumerFactoryContainsKafkaProperties() {
        ConsumerFactory<String, String> factory = config.consumerFactory();
        assertTrue(factory instanceof DefaultKafkaConsumerFactory);
        Map<String, Object> properties = ((DefaultKafkaConsumerFactory<String, String>) factory).getConfigurationProperties();
        assertEquals("127.0.0.1:9092", properties.get(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG));
        assertEquals("change.data.capture.simdb", properties.get(ConsumerConfig.GROUP_ID_CONFIG));
        assertEquals(StringDeserializer.class, properties.get(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG));
        assertEquals(StringDeserializer.class, properties.get(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG));
    }

    @Test
    void kafkaListenerContainerFactoryUsesConsumerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> listenerFactory = config.kafkaListenerContainerFactory();
        assertNotNull(listenerFactory);
        assertTrue(listenerFactory.getConsumerFactory() instanceof DefaultKafkaConsumerFactory);
        Map<String, Object> properties = ((DefaultKafkaConsumerFactory<String, String>) listenerFactory.getConsumerFactory())
                .getConfigurationProperties();
        assertEquals("change.data.capture.simdb", properties.get(ConsumerConfig.GROUP_ID_CONFIG));
    }
}
