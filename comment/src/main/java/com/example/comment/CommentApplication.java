package com.example.comment;

import com.example.comment.kafka.dto.KafkaStatus;
import com.example.comment.kafka.dto.KafkaUserBlogDto;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

import java.util.Optional;

@SpringBootApplication
@EnableFeignClients
public class CommentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentApplication.class, args);
	}

	@Bean
	public RecordMessageConverter converter(){
		return new JsonMessageConverter();
	}

	@KafkaListener( topics = "userBlog-topic")
	public void userTopicConsumer(KafkaStatus<KafkaUserBlogDto> user){
		System.out.println(user.data().nickname());
	}

}
