package com.example.parcial_backend.controllers;

import com.example.parcial_backend.dto.StatsResponse;
import com.example.parcial_backend.services.StatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final StatsService statsService;

    public StatsController (StatsService statsService){
        this.statsService = statsService;
    }

    @GetMapping
    public StatsResponse getsStats(){
        return statsService.getsStats();
    }
}
