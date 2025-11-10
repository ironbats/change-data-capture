package com.cdc.architecture.kafka.publisher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

class KafkaEventPublisherTest {

    private final KafkaTemplate<String, String> kafkaTemplate = Mockito.mock(KafkaTemplate.class);
    private final KafkaEventPublisher publisher = new KafkaEventPublisher();

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(publisher, "kafkaTemplate", kafkaTemplate);
    }

    @SuppressWarnings("unchecked")
    @Test
    void publishEventSendsMessageAndRegistersCallback() {
        String message = "payload";
        ListenableFuture<SendResult<String, String>> future = Mockito.mock(ListenableFuture.class);
        SendResult<String, String> sendResult = Mockito.mock(SendResult.class);
        RecordMetadata metadata = new RecordMetadata(new TopicPartition("stock.consolidate", 0), 0, 0,
                System.currentTimeMillis(), 0L, 0, 0);
        when(kafkaTemplate.send("stock.consolidate", KafkaEventPublisher.class.getName(), message)).thenReturn(future);
        when(sendResult.getRecordMetadata()).thenReturn(metadata);

        doAnswer(invocation -> {
            ListenableFutureCallback<SendResult<String, String>> callback = invocation.getArgument(0);
            callback.onSuccess(sendResult);
            callback.onFailure(new IllegalStateException("failure"));
            return null;
        }).when(future).addCallback(any(ListenableFutureCallback.class));

        publisher.publishEvent(message);

        verify(kafkaTemplate).send(eq("stock.consolidate"), eq(KafkaEventPublisher.class.getName()), eq(message));
        verify(future).addCallback(any(ListenableFutureCallback.class));
    }
}
