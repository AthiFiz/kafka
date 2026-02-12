package com.fiz.product.service.impl;

import com.fiz.core.ProductCreatedEvent;
import com.fiz.product.dto.CreateProductRequest;
import com.fiz.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public ProductServiceImpl(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct(CreateProductRequest request) throws Exception{

        String productId = UUID.randomUUID().toString();

        ProductCreatedEvent productCreatedEvent = ProductCreatedEvent.builder()
                .productId(productId)
                .price(request.getPrice())
                .title(request.getTitle())
                .quantity(request.getQuantity())
                .build();


        SendResult<String, ProductCreatedEvent> result =
                kafkaTemplate.send("product-created-events-topic", productId, productCreatedEvent).get();

        log.info("Partition: {}", result.getRecordMetadata().partition());
        log.info("Topic: {}", result.getRecordMetadata().topic());
        log.info("Topic: {}", result.getRecordMetadata().offset());


//        this will do the same as above.

//        CompletableFuture<SendResult<String, ProductCreatedEvent>> future =
//                kafkaTemplate.send("product-created-events-topic", productId, productCreatedEvent);
//
//        future.whenComplete((result, exception) ->{
//            if (exception != null){
//                log.error("Failed to send kafka message - {}", exception.getMessage());
//            } else {
//                log.info("Message sent successfully: {}", result.getRecordMetadata());
//            }
//        });
//
//////        will wait until the kafka response comes back
////        future.join();

        log.info("-------------Returning product id -----------");
        return productId;
    }

}
