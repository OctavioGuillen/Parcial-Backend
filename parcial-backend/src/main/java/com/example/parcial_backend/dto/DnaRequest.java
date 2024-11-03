package com.example.parcial_backend.dto;

import com.example.parcial_backend.validators.ValidDna;
import lombok.*;

@Getter
@Setter
public class DnaRequest {
    @ValidDna
    private String[] dna;
}
