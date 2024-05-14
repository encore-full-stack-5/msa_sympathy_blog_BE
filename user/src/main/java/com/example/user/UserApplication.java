package com.example.user;

import com.example.user.kafka.dto.KafkaStatus;
import com.example.user.kafka.dto.KafkaUserBlogDto;
import com.example.user.kafka.producer.UserBlogIdProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@SpringBootApplication
@EnableScheduling
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public RecordMessageConverter converter(){
		return new JsonMessageConverter();
	}

	public static class KafkaInitiator {

		@Autowired
		private UserBlogIdProducer userBlogIdProducer;
		@Autowired
		private KafkaTemplate<String, KafkaStatus<KafkaUserBlogDto>> kafkaTemplate;

		@Scheduled(cron = "* * * * * *")
		public void init() {
			KafkaUserBlogDto kafkaUserBlogDto = new KafkaUserBlogDto(UUID.randomUUID().toString(), "aa");
			userBlogIdProducer.send(kafkaUserBlogDto, "update");
		}
	}


}

