package com.example.user.service;

import com.example.user.dto.request.NeighborRequest;
import com.example.user.global.domain.entity.Neighbor;
import com.example.user.global.domain.repository.NeighborRepository;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class NeighborServiceTest {

    @Test
    void 이웃추가() {
        //given
        NeighborRequest request = new NeighborRequest(UUID.randomUUID().toString(),
                type(null));

                )
        //when
        Neighbor save = NeighborRepository.save(request.toEntity());
        //then
    }

    @Test
    void 이웃삭제() {
    }
    @Test
    void 이웃수락() {

    }
    @Test
    void 이웃거절(){

    }
}