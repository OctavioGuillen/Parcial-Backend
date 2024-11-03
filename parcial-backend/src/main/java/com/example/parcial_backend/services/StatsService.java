package com.example.parcial_backend.services;

import com.example.parcial_backend.dto.StatsResponse;
import com.example.parcial_backend.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    private final DnaRepository dnaRepository;

    @Autowired
    public StatsService(DnaRepository dnaRepository){
        this.dnaRepository = dnaRepository;
    }

    public StatsResponse getsStats(){
        long countMutantDna = dnaRepository.countByIsMutant(true);
        long countHumanDna = dnaRepository.countByIsMutant(false);
        double ratio = countHumanDna == 0 ? 0 : (double) countMutantDna / countHumanDna;
        return new StatsResponse(countMutantDna, countHumanDna, ratio);

    }
}
