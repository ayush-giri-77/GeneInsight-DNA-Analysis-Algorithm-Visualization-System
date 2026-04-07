package com.geneinsight.service;

public class MutationService {

    public static void detectMutation(String dna1, String dna2) {

        System.out.println("\n=== Mutation Analysis (Advanced) ===");

        int i = 0, j = 0;

        boolean mutationFound = false;

        int substitutions = 0;
        int insertions = 0;
        int deletions = 0;

        while (i < dna1.length() && j < dna2.length()) {

            if (dna1.charAt(i) == dna2.charAt(j)) {
                i++;
                j++;
            }
            else {
                // Substitution
                if (i + 1 < dna1.length() && j + 1 < dna2.length()
                        && dna1.charAt(i + 1) == dna2.charAt(j + 1)) {

                    System.out.println("Substitution at position " + i +
                            ": " + dna1.charAt(i) + " → " + dna2.charAt(j));

                    substitutions++;
                    mutationFound = true;

                    i++;
                    j++;
                }
                // Insertion
                else if (j + 1 < dna2.length() && dna1.charAt(i) == dna2.charAt(j + 1)) {

                    System.out.println("Insertion at position " + i +
                            ": " + dna2.charAt(j) + " inserted");

                    insertions++;
                    mutationFound = true;

                    j++;
                }
                // Deletion
                else if (i + 1 < dna1.length() && dna1.charAt(i + 1) == dna2.charAt(j)) {

                    System.out.println("Deletion at position " + i +
                            ": " + dna1.charAt(i) + " removed");

                    deletions++;
                    mutationFound = true;

                    i++;
                }
                else {
                    // fallback substitution
                    System.out.println("Substitution at position " + i +
                            ": " + dna1.charAt(i) + " → " + dna2.charAt(j));

                    substitutions++;
                    mutationFound = true;

                    i++;
                    j++;
                }
            }
        }

        // Remaining insertions
        while (j < dna2.length()) {
            System.out.println("Insertion at end: " + dna2.charAt(j));

            insertions++;
            mutationFound = true;

            j++;
        }

        // Remaining deletions
        while (i < dna1.length()) {
            System.out.println("Deletion at end: " + dna1.charAt(i));

            deletions++;
            mutationFound = true;

            i++;
        }

        // ✅ No mutation case
        if (!mutationFound) {
            System.out.println("No mutations detected ✅");
        }

        // ✅ Summary
        System.out.println("\n--- Summary ---");
        System.out.println("Substitutions: " + substitutions);
        System.out.println("Insertions: " + insertions);
        System.out.println("Deletions: " + deletions);
        System.out.println("Total Mutations: " +
                (substitutions + insertions + deletions));
    }
}
