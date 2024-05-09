package com.example.user.global.domain.repository;

import com.example.user.dto.request.NeighborRequest;
import com.example.user.global.domain.entity.Neighbor;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class NeighborRepositoryTest {

    @Test
    void findByResponseUserIdAndAndRequestUserId() {
        //given
        Long responseUserId = 1L;
        Long requestUserId = 2L;
        //when
        Optional<Neighbor> neighbor = NeighborRepository.findByResponseUserIdAndAndRequestUserId(requestUserId,responseUserId);
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
        Optional<Neighbor> neighbor = NeighborRepository.findByType(type);
        //then
        assertTrue(neighbor.isPresent());
        assertEquals(type, neighbor.get().getType());

    }
}