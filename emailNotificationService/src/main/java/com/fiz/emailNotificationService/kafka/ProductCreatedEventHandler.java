package com.fiz.emailNotificationService.kafka;

import com.fiz.core.ProductCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductCreatedEventHandler {

    @KafkaListener(topics = "product-created-events-topic")
    public void handle(ProductCreatedEvent productCreatedEvent){
        log.info("Received a new event: {}", productCreatedEvent.getTitle());
        log.info("Publishing event: {}", productCreatedEvent);
        log.info(String.valueOf(productCreatedEvent));
    }

}
