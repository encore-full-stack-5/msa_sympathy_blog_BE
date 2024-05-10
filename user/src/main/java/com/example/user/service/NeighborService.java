package com.example.user.service;

import com.example.user.dto.request.NeighborRequest;

import java.util.List;

public interface NeighborService {
    void addNeighbor(NeighborRequest request);
    void deleteNeighbor(NeighborRequest request);

    void acceptNeighborRequest (NeighborRequest request);
    void rejectNeighborRequest (NeighborRequest request);


}
