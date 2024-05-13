package com.example.user.service;

import com.example.user.dto.request.TodayRequest;
import com.example.user.global.domain.entity.Today;
import com.example.user.global.domain.repository.TodayRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.List;
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

        List<Today> byUserBlogIds = todayRepository.findByUserBlogId(UUID.fromString(request.userBlogId()));

        if(byUserBlogIds.isEmpty())throw new IllegalArgumentException("못찾음");

        for(Today aa : byUserBlogIds){

            assertEquals(save.getId(),aa.getId());

        }





    }
}