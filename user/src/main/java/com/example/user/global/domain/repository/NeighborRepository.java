package com.example.user.global.domain.repository;

import com.example.user.global.domain.entity.Neighbor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NeighborRepository extends JpaRepository<Neighbor, UUID>{




}
