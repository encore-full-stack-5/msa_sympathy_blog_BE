package com.example.user.service;

import com.example.user.dto.request.NeighborRequest;
import com.example.user.global.domain.entity.Neighbor;
import com.example.user.global.domain.entity.UserBlog;
import com.example.user.global.domain.repository.NeighborRepository;
import com.example.user.global.domain.repository.UserBlogRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class NeighborServiceTest {
    @Autowired
    private NeighborRepository neighborRepository;
    @Autowired
    private NeighborService neighborService;
    @Autowired
    UserBlogRepository userBlogRepository;

    @Test
    void 이웃추가() {
        //given
//        String userBlogId = UUID.randomUUID().toString();
        UserBlog userBlog = userBlogRepository.save(UserBlog.builder().build());
        String type = "이웃아님";
        boolean status = false;
        NeighborRequest request = new NeighborRequest(userBlog.getId().toString(), type, status);

        // when
        neighborService.addNeighbor(request);

        //then
        Optional<Neighbor> savedNeighbor = neighborRepository.findByType(type);
        assertTrue(savedNeighbor.isPresent());

        Neighbor neighbor = savedNeighbor.get();
        assertEquals(userBlog.getId().toString(), neighbor.getUserBlog().getId().toString());
        assertEquals(type, neighbor.getType());
        assertEquals(status, neighbor.getStatus());
    }


    @Test
    void 이웃삭제() {
        //given
        String type = "이웃";
        boolean status = false;
        UserBlog userBlog = userBlogRepository.save(UserBlog.builder().build());
       Neighbor neighbor = Neighbor.builder().userBlog(userBlog).type(type).build();
       neighborRepository.save(neighbor);

        NeighborRequest request = new NeighborRequest(userBlog.getId().toString(), type, status);
        //when
        neighborService.deleteNeighbor(request);
        //then

        Optional<Neighbor> savedNeighbor = neighborRepository.findByType(type);
        assertFalse(savedNeighbor.isPresent());

    }

    @Test
    void 이웃수락() {
//        //given
//       Long requestUserId =  1l;
//      Long responseUserId = 2l;
//      Boolean status = false;
//      Neighbor neighbor = Neighbor.builder()
//              .requestUserId(requestUserId)
//              .responseUserId(responseUserId)
//              .status(false)
//              .build();
//      neighborRepository.save(neighbor);
//       NeighborRequest request = new NeighborRequest(requestUserId(),responseUserId,status);
//       //when
//       neighborService.acceptNeighborRequest(request);
//       //then
//        Optional<Neighbor> savedNeighbor = neighborRepository.findByStatus(status);
//        assertTrue(savedNeighbor.isPresent());
//        Neighbor neighbor1 = savedNeighbor.get();
//        assertEquals(requestUserId, neighbor1.getRequestUserId());
//        assertEquals(responseUserId, neighbor1.getResponseUserId());
//        assertEquals(status, neighbor1.getStatus());
    }

    @Test
    void 이웃거절() {
//        Long requestUserId =  1l;
//        Long responseUserId = 2l;
//        Boolean status = false;
//
//        //given
//        //when
//        //then

    }
}
