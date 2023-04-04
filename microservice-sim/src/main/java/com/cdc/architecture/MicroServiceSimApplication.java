package com.cdc.architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MicroServiceSimApplication {

//    @Autowired
//    private KafkaEventPublisher kafkaEventPublisher;

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceSimApplication.class);


    }
//
//    @PostConstruct
//    public void message(){
//        kafkaEventPublisher.publishEvent("teste_kafka");
//    }

}