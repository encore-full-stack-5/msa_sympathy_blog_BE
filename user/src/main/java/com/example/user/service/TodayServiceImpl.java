package com.example.user.service;

import com.example.user.dto.request.TodayRequest;
import com.example.user.global.domain.entity.Today;
import com.example.user.global.domain.repository.TodayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodayServiceImpl implements TodayService{

    private final TodayRepository todayRepository;

    @Override
    public void save(TodayRequest request) {

        List<Today> byUserBlogIdAndDate =
                todayRepository.findByUserBlogIdAndDate(UUID.fromString(request.userBlogId()), request.date());
        Today todayRecord;
        if (byUserBlogIdAndDate
                .isEmpty()) {

            todayRecord = request.toEntity();

            todayRepository.save(request.toEntity());
        } else {

            todayRecord = byUserBlogIdAndDate
                    .get(0);
            todayRecord.setCount(todayRecord.getCount() + 1);
        }
        todayRepository.save(todayRecord);
    }

    @Override
    public int showCount(TodayRequest request) {

        List<Today> byUserBlogIdAndDate = todayRepository.findByUserBlogIdAndDate(UUID.fromString(request.userBlogId()), LocalDate.now());

        if(byUserBlogIdAndDate.isEmpty()){
            throw new IllegalArgumentException("데이터가 없습니다.");
        }
        int count=0;
        for(Today aa : byUserBlogIdAndDate){

            count = aa.getCount();
        }

        return count;
    }
}
