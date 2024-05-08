package com.example.user.global.domain.repository;

import com.example.user.global.domain.entity.Today;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TodayRepository extends CrudRepository<Today, UUID> {
}
