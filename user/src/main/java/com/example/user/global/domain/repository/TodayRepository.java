package com.example.user.global.domain.repository;

import com.example.user.global.domain.entity.Today;
import org.springframework.data.repository.CrudRepository;

public interface TodayRepository extends CrudRepository<Today, Long> {
}
