package com.example.user.service;

import com.example.user.global.domain.repository.NeighborRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NeighborImpl {
    private final NeighborRepository neighborRepository;

    //이웃추가
    @Override
    public void addNeighbor(Long requestUserId, Long responseUserId) {
        Neighbor neighbor = Neighbor.builder()
                .requestUserId(requestUserId)
                .responseUserId(responseUserId)
                .type(type)
                .status(false)
                .build();
        return neighborRepository.save(neighbor);
    }
        //이웃삭제
        @Override
        public void removeNeighbor(Long neighborId){
        neighborRepository.deleteById(neighborId);
        public void removeNeighbor
        //이웃수락
        @Override
        //이웃거절
        @Override

    }
}
