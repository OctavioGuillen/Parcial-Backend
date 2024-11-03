package com.example.parcial_backend.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DnaServiceTest {

    //Test cubriendo todas las secuencias de matriz 6x6
    @Test
    public void testRows(){
        String[] dna = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTC",
                "AGTCAC",
        };
        assertTrue(DnaService.isMutant(dna));
    }

    @Test
    public void testColumns(){
        String[] dna = {
                "AGAATG",
                "TGCAGT",
                "GCTTCC",
                "GTCCTG",
                "GTAGTC",
                "GGTCAC",
        };
        assertTrue(DnaService.isMutant(dna));
    }

    @Test
    public void testMainDiagonals(){
        String[] dna = {
                "AGAATG",
                "TACAGT",
                "GCAGCC",
                "TTGATG",
                "GTAGTC",
                "AGTCAA",
        };
        assertTrue(DnaService.isMutant(dna));
    }

    @Test
    public void testSecondaryLeftDiagonals(){
        String[] dna = {
                "ATAATG",
                "GTTAGT",
                "GGCTCG",
                "TTGATG",
                "GTAGTC",
                "AGTCAA",
        };
        assertTrue(DnaService.isMutant(dna));
    }

    @Test
    public void testSecondaryRightDiagonals(){
        String[] dna = {
                "ATAATG",
                "GTATGA",
                "GCTTAG",
                "TTTAGG",
                "GTAGTC",
                "AGTCAA",
        };
        assertTrue(DnaService.isMutant(dna));
    }

    @Test
    public void testTertiaryLeftDiagonals(){
        String[] dna = {
                "ATGATG",
                "GTAGTA",
                "CCTTGG",
                "TCTAGG",
                "GGCGTC",
                "AGTCAA",
        };
        assertTrue(DnaService.isMutant(dna));
    }

    @Test
    public void testTertiaryRightDiagonals(){
        String[] dna = {
                "ATGATG",
                "GTATTA",
                "AATTGG",
                "ACTAGT",
                "GGAGTC",
                "AGGCAA",
        };
        assertTrue(DnaService.isMutant(dna));
    }

    @Test
    public void testNonMutant(){
        String[] dna = {
                "ATGATG",
                "GTCTTA",
                "AATTGG",
                "ACTAGT",
                "GGATTC",
                "AGGCAA",
        };
        assertTrue(DnaService.isMutant(dna));
    }
}
