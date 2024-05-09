package com.example.user.service;

import com.example.user.dto.request.NeighborRequest;
import com.example.user.global.domain.entity.Neighbor;
import com.example.user.global.domain.repository.NeighborRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NeighborServiceImpl implements NeighborService {
    private final NeighborRepository neighborRepository;

    //이웃추가
    @Override
    public void neighborAdd(NeighborRequest request){
        //
        Optional<Neighbor> neighbor = neighborRepository.findByType(request.type());
        if(neighbor.isPresent()){
            throw new IllegalArgumentException("이미 이웃입니다");
        }
        else {
            Neighbor newNeighbor = request.toEntity();
            neighborRepository.save(newNeighbor);
        }
    }
    //이웃삭제
    @Override
    public void deleteNeighbor(NeighborRequest request) {
        Optional<Neighbor> neighbor1 = neighborRepository.findByType(request.type());
        if (neighbor1.isPresent()) {
            neighborRepository.delete(neighbor1.get());
        } else {
            throw new IllegalArgumentException("이웃이 아닙니다");
        }
    }


    //이웃수락
        @Override
        public void acceptNeighborRequest(NeighborRequest request){
            Long requestUserId = request.toEntity().getRequestUserId();
            Long responseUserId = request.toEntity().getResponseUserId();
           Optional<Neighbor> neighbor2 = neighborRepository.findByResponseUserIdAndAndRequestUserId(requestUserId,responseUserId);
           if(neighbor2.isPresent()){
               Neighbor acceptedNeighbor = request.toEntity();
               acceptedNeighbor.builder()
                       .requestUserId(requestUserId)
                       .responseUserId(responseUserId)
                               .status(true)
                                       .build();
               neighborRepository.save(acceptedNeighbor);
           }
           else {
               throw new IllegalArgumentException("이웃요청이 없습니다");
           }


            }
        //이웃거절
        @Override
        public void rejectNeighborRequest(NeighborRequest request){
                    Long requestUserId = request.toEntity().getRequestUserId();
                    Long responseUserId = request.toEntity().getResponseUserId();
                    Optional<Neighbor> neighbor3 = neighborRepository.findByResponseUserIdAndAndRequestUserId(requestUserId,responseUserId);
                    if(neighbor3.isPresent()){
                        Neighbor rejectedNeighbor = Neighbor.builder()
                                .requestUserId(requestUserId)
                                .responseUserId(responseUserId)
                                .status(false)
                                .build();
                        neighborRepository.save(rejectedNeighbor);
                    }
                    else {
                        throw new IllegalArgumentException("이웃요청이 없습니다");
                    }

            }

    }

