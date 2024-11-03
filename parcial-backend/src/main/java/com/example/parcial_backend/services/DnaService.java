package com.example.parcial_backend.services;

import com.example.parcial_backend.entities.Dna;
import com.example.parcial_backend.repositories.DnaRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Builder
@Getter
@Setter
@Service
public class DnaService {

    private static final int SEQUENCE_LENGHT = 6;
    private final DnaRepository dnaRepository;

    public DnaService(DnaRepository dnaRepository){
        this.dnaRepository = dnaRepository;
    }

    public static boolean isMutant(String[] dna){
        int n = dna.length;
        int sequenceCount = 0;

        //Verificamos filas
        sequenceCount += checkRows(dna, n);
        if (sequenceCount > 1) return true;

        //Verificamos columnas
        sequenceCount += checkColumns(dna, n);
        if (sequenceCount > 1) return true;

        //Verificamos diagonales
        sequenceCount += checkDiagonals(dna, n);
        return sequenceCount > 1;
    }

    private static int checkRows(String[] dna, int n){
        int sequenceCount = 0;

        for (int i = 0; i < n; i++){
            int count = 1;
            for (int j = 1; j < n; j++){
                if (dna[i].charAt(j) == dna[i].charAt(j-1)){
                    count++;
                    if (count == SEQUENCE_LENGHT) {
                        sequenceCount++;
                        if (sequenceCount > 1) return sequenceCount;
                    }
                } else {
                    count = 1;
                }
            }
        }
        return sequenceCount;
    }

    private static int checkColumns(String[] dna, int n){
        int sequenceCount = 0;

        for (int j = 0; j < n; j++){
            int count = 1;
            for (int i = 1; i < n; i++){
                if (dna[i].charAt(j) == dna[i-1].charAt(j)){
                    count++;
                    if (count == SEQUENCE_LENGHT) {
                        sequenceCount++;
                        if (sequenceCount > 1) return sequenceCount;
                    }
                } else {
                    count = 1;
                }
            }
        }
        return sequenceCount;
    }

    private static int checkDiagonals(String[] dna, int n){
        int sequenceCount = 0;

        //Diagonales de izquierda(arriba) a derecha(abajo)
        for (int i = 0; i <= n- SEQUENCE_LENGHT; i++) {
            for (int j = 0; j <= n- SEQUENCE_LENGHT; j++) {
                if(checkDiagonal(dna, i, j, 1, 1, n)){
                    sequenceCount++;
                    if (sequenceCount > 1) return sequenceCount;
                }
            }
        }

        //Diagonales de derecha(arriba) a izquierda(abajo)
        for (int i = 0; i <= n- SEQUENCE_LENGHT; i++) {
            for (int j = 0; j <= n- SEQUENCE_LENGHT; j++) {
                if(checkDiagonal(dna, i, j, 1, -1, n)){
                    sequenceCount++;
                    if (sequenceCount > 1) return sequenceCount;
                }
            }
        }
        return sequenceCount;
    }

    private static boolean checkDiagonal(String[] dna, int x, int y, int dx, int dy, int n){
        char first = dna[x].charAt(y);
        for (int i = 1; i < SEQUENCE_LENGHT; i++){
            if (x+i*dx >= n || y+i*dy >= n || y+i*dy < 0 || x+i*dx < 0){
                return false;
            }
        }
        return true;
    }

    public boolean analyzeDna(String[] dna){

        String dnaSequence = String.join(",", dna);

        //Verifica si el ADN ya existe en la base de datos
        Optional<Dna> existingDna = dnaRepository.findByDna(dnaSequence);
        if (existingDna.isPresent()){
            //Si el ADN ya fue analizado, retorna el resultado
            return existingDna.get().isMutant();
        }

        //Determina si el ADN es mutante y lo guarda en base de datos
        boolean isMutant = isMutant(dna);
        Dna dnaEntity = Dna.builder()
                .dna(dnaSequence)
                .isMutant(isMutant)
                .build();
        dnaRepository.save(dnaEntity);

        return isMutant(dna);
    }
}
