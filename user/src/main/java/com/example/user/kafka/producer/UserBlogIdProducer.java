package com.example.user.kafka.producer;


import com.example.user.global.domain.entity.UserBlog;
import com.example.user.global.dto.UserBlogDto;
import com.example.user.kafka.dto.KafkaStatus;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserBlogIdProducer {
    private final KafkaTemplate<String, KafkaStatus<UserBlogDto>> kafkaTemplate;
    @Value("${kafka.product.name}") private String name;

    @Bean
    private NewTopic newTopic(){
        return new NewTopic(name, 1, (short) 1);
    }

    public void send(UserBlogDto userBlogDto, String status){
        KafkaStatus<UserBlogDto> kafkaStatus = new KafkaStatus<>(userBlogDto, status);
        kafkaTemplate.send(name, kafkaStatus);
    }

}
