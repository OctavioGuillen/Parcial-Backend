package com.example.parcial_backend.controllers;

import com.example.parcial_backend.dto.DnaRequest;
import com.example.parcial_backend.dto.DnaResponse;
import com.example.parcial_backend.services.DnaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mutant")
public class DnaController {

    private final DnaService dnaService;

    public DnaController(DnaService dnaservice){
        this.dnaService = dnaservice;
    }

    @PostMapping
    public ResponseEntity<DnaResponse> checkMutant (@Valid @RequestBody DnaRequest dnaRequest){
        boolean isMutant = dnaService.analyzeDna(dnaRequest.getDna());
        DnaResponse dnaResponse = new DnaResponse(isMutant);
        if (isMutant){
            return ResponseEntity.ok(dnaResponse);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dnaResponse);
        }
    }
}
