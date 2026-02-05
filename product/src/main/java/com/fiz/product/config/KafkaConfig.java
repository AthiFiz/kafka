package com.fiz.product.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    NewTopic createTopic(){
        return TopicBuilder.name("product-created-events-topic")
                .partitions(3)
                .replicas(1) // if 3 replicas, then 3 kafka servers should run
//                .configs(Map.of("min.insync.replicas", "2"))
                .build();
    }

}
