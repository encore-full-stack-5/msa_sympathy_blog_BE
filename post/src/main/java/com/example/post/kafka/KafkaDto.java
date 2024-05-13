package com.example.post.kafka;

public record KafkaDto<T>(
        T data,
        String status
) {
}
