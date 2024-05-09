package com.example.user.service;

import com.example.user.dto.request.TodayRequest;
import com.example.user.global.domain.entity.Today;
import com.example.user.global.domain.repository.TodayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodayServiceImpl implements TodayService{

    private final TodayRepository todayRepository;

    @Override
    public void save(TodayRequest request) {

    Optional<Today> byUserBlogIdAndDate = todayRepository.findByUserBlogIdAndDate(UUID.fromString(request.userBlogId()), LocalDate.now());

    byUserBlogIdAndDate.orElseThrow(()->new IllegalArgumentException("오늘 날짜 해당 블로그 정보가 없습니다."));

    int i = byUserBlogIdAndDate.get().getCount() + 1;

    Today build = Today.builder().userBlogId(UUID.fromString(request.userBlogId())).count(i).build();

    todayRepository.save(build);


    }

    @Override
    public int showCount(TodayRequest request) {

        Optional<Today> byUserBlogIdAndDate = todayRepository.findByUserBlogIdAndDate(UUID.fromString(request.userBlogId()), LocalDate.now());

        byUserBlogIdAndDate.orElseThrow(()->new IllegalArgumentException("오늘 날짜 해당 블로그 정보가 없습니다."));

        int count = byUserBlogIdAndDate.get().getCount();

        return count;
    }
}
