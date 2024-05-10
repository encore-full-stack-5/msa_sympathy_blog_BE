package com.example.user.global.domain.repository;

import com.example.user.global.domain.entity.Today;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface TodayRepository extends CrudRepository<Today, UUID> {

    Optional<Today> findByUserBlogIdAndDate(UUID userBlogId, LocalDate date);

    Optional<Today> findByDate(LocalDate date);

    Optional<Today> findByUserBlogId(UUID userBlogId);


}
