package com.example.parcial_backend.dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
public class DnaResponse {
    private boolean isMutant;

    public boolean isMutant() {
        return isMutant;
    }
}
