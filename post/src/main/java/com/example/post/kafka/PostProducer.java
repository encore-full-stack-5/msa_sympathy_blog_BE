package com.example.post.kafka;
import com.example.post.global.domain.entity.Post;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PostProducer {
    private final KafkaTemplate<String, KafkaDto<Post>> kafkaTemplate;
}
