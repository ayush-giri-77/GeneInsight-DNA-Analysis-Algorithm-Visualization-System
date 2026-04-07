package com.geneinsight.utils;

public class DNAUtils {
    public static String getComplement(String dna) {
        StringBuilder result = new StringBuilder();

        for (char c : dna.toCharArray()) {
            switch (c) {
                case 'A' -> result.append('T');
                case 'T' -> result.append('A');
                case 'C' -> result.append('G');
                case 'G' -> result.append('C');
                default -> result.append(c);
            }
        }
        return result.toString();
    }

    public static String getReverseComplement(String dna) {
        return new StringBuilder(getComplement(dna)).reverse().toString();
    }
}