package com.geneinsight.service;

public class DNAVisualizer {

    public static void visualize(String dna1, String dna2) {

        System.out.println("\n=== DNA Alignment Visualization ===\n");

        int i = 0, j = 0;

        StringBuilder top = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder bottom = new StringBuilder();

        while (i < dna1.length() && j < dna2.length()) {

            char c1 = dna1.charAt(i);
            char c2 = dna2.charAt(j);

            top.append(c1).append(" ");
            bottom.append(c2).append(" ");

            if (c1 == c2) {
                mid.append("| ");
                i++;
                j++;
            }
            else if (i + 1 < dna1.length() && dna1.charAt(i + 1) == c2) {
                mid.append("- ");
                i++;
            }
            else if (j + 1 < dna2.length() && dna2.charAt(j + 1) == c1) {
                mid.append("+ ");
                j++;
            }
            else {
                mid.append("* ");
                i++;
                j++;
            }
        }

        while (i < dna1.length()) {
            top.append(dna1.charAt(i)).append(" ");
            bottom.append("  ");
            mid.append("- ");
            i++;
        }

        while (j < dna2.length()) {
            top.append("  ");
            bottom.append(dna2.charAt(j)).append(" ");
            mid.append("+ ");
            j++;
        }

        System.out.println("DNA1: " + top);
        System.out.println("      " + mid);
        System.out.println("DNA2: " + bottom);

        System.out.println("\nLegend:");
        System.out.println("| → Match");
        System.out.println("* → Substitution");
        System.out.println("+ → Insertion");
        System.out.println("- → Deletion");
    }
}
