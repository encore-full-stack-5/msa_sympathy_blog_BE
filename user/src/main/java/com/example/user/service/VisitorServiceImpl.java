package com.example.user.service;
import com.example.user.dto.request.VisitorRequest;
import com.example.user.global.domain.entity.Today;
import com.example.user.global.domain.entity.Visitor;
import com.example.user.global.domain.repository.TodayRepository;
import com.example.user.global.domain.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VisitorServiceImpl implements VisitorService{

    private final VisitorRepository visitorRepository;
    private final TodayRepository todayRepository;

    @Override
    public void save(VisitorRequest request) {

        List<Today> byUserBlogIdAndDate =
                //당일 날짜로 블로그 아이디로 TODAY 데이터를 찾아냄
                todayRepository.findByUserBlogIdAndDate(UUID.fromString(request.userBlogId()), LocalDate.now());
        if(byUserBlogIdAndDate.isEmpty()){
            //당일 방문자는 0명으로 저장함
            visitorRepository.save(request.toEntity());
        }
        //당일 날짜로 블로그 아이디로 TODAY 데이터를 찾아내고 당일 방문자 수 저장
        int count=0;
        for(Today aa:byUserBlogIdAndDate){

            count += aa.getCount();
        }
        Visitor visitor = Visitor.builder().count(count).date(request.localDate()).build();
        visitorRepository.save(visitor);
    }

    @Override
    public List<Visitor> showVisitor(VisitorRequest request) {

        List<Visitor> byUserBlogId = visitorRepository.findByUserBlogId(UUID.fromString(request.userBlogId()));

        if(byUserBlogId.isEmpty()){

            throw new IllegalArgumentException("정보가 없다.");
        }

        return byUserBlogId;
    }
}
