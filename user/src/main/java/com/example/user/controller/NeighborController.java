package com.example.user.controller;

import com.example.user.service.NeighborService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/neighbor")
public class NeighborController {
    private final NeighborService neighborService;
//    //이웃추가
//    @PostMapping("")
//    //이웃삭제
//    @DeleteMapping("/delete/")
//
//    //
}
