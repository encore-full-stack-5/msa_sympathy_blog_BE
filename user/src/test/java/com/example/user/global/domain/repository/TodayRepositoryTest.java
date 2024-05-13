package com.example.user.global.domain.repository;

import com.example.user.dto.request.TodayRequest;
import com.example.user.global.domain.entity.Today;
import com.example.user.service.TodayService;
import com.example.user.service.TodayServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
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

        // Initial record for 2024-05-08
        TodayRequest initialRequest = new TodayRequest(UUID.randomUUID().toString(), LocalDate.of(2024, 5, 8));
        Today saved = todayRepository.save(initialRequest.toEntity());

        // Create a new service instance for testing
        TodayServiceImpl todayService = new TodayServiceImpl(todayRepository);

        // Increment for 2024-05-08 by calling the save method
        TodayRequest duplicateDateRequest = new TodayRequest(saved.getUserBlogId().toString(), LocalDate.of(2024, 5, 8));
        todayService.save(duplicateDateRequest);

        // New date request (2024-05-09)
        TodayRequest newDateRequest = new TodayRequest(saved.getUserBlogId().toString(), LocalDate.of(2024, 5, 9));
        todayService.save(newDateRequest);

        // Verify the count incremented correctly
        List<Today> forFirstDate = todayRepository.findByUserBlogIdAndDate(UUID.fromString(saved.getUserBlogId().toString()), LocalDate.of(2024, 5, 8));
        List<Today> forSecondDate = todayRepository.findByUserBlogIdAndDate(UUID.fromString(saved.getUserBlogId().toString()), LocalDate.of(2024, 5, 9));

        for (Today record : forFirstDate) {
            System.out.println("2024-05-08: Count = " + record.getCount());
        }

        for (Today record : forSecondDate) {
            System.out.println("2024-05-09: Count = " + record.getCount());
        }


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