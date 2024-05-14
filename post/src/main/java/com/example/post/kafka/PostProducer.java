package com.example.post.kafka;
import com.example.post.global.domain.entity.Post;
import com.example.post.kafka.dto.KafkaPostDto;
import com.example.post.kafka.dto.KafkaStatus;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PostProducer {
    private final KafkaTemplate<String, KafkaStatus<KafkaPostDto>> kafkaTemplate;

    @Bean
    public NewTopic postTopic() {
        return new NewTopic("post-topic", 1, (short) 1);
    }

    public void send(KafkaPostDto kafkaPostDto, String status) {
        KafkaStatus<KafkaPostDto> kafkaStatus = new KafkaStatus<>(kafkaPostDto, status);
        kafkaTemplate.send("post-topic", kafkaStatus);
    }

    public PostProducer(KafkaTemplate<String, KafkaStatus<KafkaPostDto>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
}
