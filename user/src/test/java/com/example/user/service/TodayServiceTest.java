package com.example.user.service;

import com.example.user.dto.request.TodayRequest;
import com.example.user.global.domain.entity.Today;
import com.example.user.global.domain.repository.TodayRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TodayServiceTest {

    @Autowired
    private TodayService todayService;
    @Autowired
    private TodayRepository todayRepository;

    @Test
    void save() {

        TodayRequest request = new TodayRequest(UUID.randomUUID().toString(),
                LocalDate.of(2000, 4, 7));


        Today save = todayRepository.save(request.toEntity());

        Optional<Today> byUserBlogId = todayRepository.findByUserBlogId(UUID.fromString(request.userBlogId()));

        byUserBlogId.orElseThrow(()->new IllegalArgumentException("못찾음"));

        assertEquals(save,byUserBlogId.get());




    }
}