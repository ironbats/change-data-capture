package com.cdc.architecture.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

class KafkaProducerConfigTest {

    private final KafkaProducerConfig config = new KafkaProducerConfig();

    @Test
    void producerFactoryContainsKafkaProperties() {
        ProducerFactory<String, String> factory = config.producerFactory();
        assertTrue(factory instanceof DefaultKafkaProducerFactory);

        Map<String, Object> properties = ((DefaultKafkaProducerFactory<String, String>) factory).getConfigurationProperties();
        assertEquals("127.0.0.1:9092", properties.get(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG));
        assertEquals(StringSerializer.class, properties.get(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG));
        assertEquals(StringSerializer.class, properties.get(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG));
    }

    @Test
    void kafkaTemplateIsCreatedWithProducerFactory() {
        KafkaTemplate<String, String> template = config.kafkaTemplate();
        assertNotNull(template);
        ProducerFactory<String, String> factory = template.getProducerFactory();
        assertTrue(factory instanceof DefaultKafkaProducerFactory);
        Map<String, Object> properties = ((DefaultKafkaProducerFactory<String, String>) factory).getConfigurationProperties();
        assertEquals("127.0.0.1:9092", properties.get(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG));
    }
}
