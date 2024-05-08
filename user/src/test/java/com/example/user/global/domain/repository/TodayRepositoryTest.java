package com.example.user.global.domain.repository;

import com.example.user.dto.request.TodayRequest;
import com.example.user.global.domain.entity.Today;
import com.example.user.service.TodayService;
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
class TodayRepositoryTest {

    @Autowired
    private TodayService todayService;
    @Autowired
    private TodayRepository todayRepository;

    @Test
    void findByUserBlogIdAndDate() {

        TodayRequest request = new TodayRequest(UUID.randomUUID().toString(),
                LocalDate.of(2024, 5, 8));


        Today save = todayRepository.save(request.toEntity());

        Optional<Today> byUserBlogIdAndDate = todayRepository.findByUserBlogIdAndDate(UUID.fromString(request.userBlogId()), request.date());

        assertEquals(byUserBlogIdAndDate.get().getId(),save.getId());

    }

    @Test
    void findByDate() {

        TodayRequest request = new TodayRequest(UUID.randomUUID().toString(),
                LocalDate.of(2024, 5, 8));


        Today save = todayRepository.save(request.toEntity());


        Optional<Today> byDate = todayRepository.findByDate(request.date());


        System.out.println(save.getDate());
        System.out.println(request.date());
        assertEquals(save.getId(),byDate.get().getId());
    }
}