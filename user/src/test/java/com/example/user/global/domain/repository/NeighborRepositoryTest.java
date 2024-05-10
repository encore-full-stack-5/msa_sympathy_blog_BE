package com.example.user.global.domain.repository;


import com.example.user.global.domain.entity.Neighbor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@Transactional
class NeighborRepositoryTest {
    @Autowired
    private NeighborRepository neighborRepository;


    @Test
    void findByResponseUserIdAndRequestUserId() {
        //given
        UUID responseUserId = UUID.randomUUID();

        UUID requestUserId = UUID.randomUUID();
        //when
        Optional<Neighbor> neighbor = neighborRepository.findByResponseUserIdAndRequestUserId(responseUserId,requestUserId);
        //then
        assertTrue(neighbor.isPresent());
        assertEquals(responseUserId, neighbor.get().getResponseUserId());
        assertEquals(requestUserId, neighbor.get().getRequestUserId());

    }

    @Test
    void findByType() {
        //given
        String type = "서로이웃";
        //when
        Optional<Neighbor> neighbor = neighborRepository.findByType(type);
        //then
        assertTrue(neighbor.isPresent());
        assertEquals(type, neighbor.get().getType());

    }
}