package com.example.user.global.domain.repository;

import com.example.user.global.domain.entity.Neighbor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NeighborRepository extends JpaRepository<Neighbor, Long> {
}
