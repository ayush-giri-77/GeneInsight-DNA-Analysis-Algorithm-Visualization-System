package com.geneinsight.utils;

public class InputValidator {
    public static boolean isValidDNA(String dna) {
        return dna != null && dna.matches("[ACGT]+");
    }
}
