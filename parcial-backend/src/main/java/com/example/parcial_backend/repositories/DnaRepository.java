package com.example.parcial_backend.repositories;

import com.example.parcial_backend.entities.Dna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DnaRepository extends JpaRepository<Dna, Long> {
    Optional<Dna> findByDna(String dnaSequence);

    long countByIsMutant(boolean isMutant);
}
