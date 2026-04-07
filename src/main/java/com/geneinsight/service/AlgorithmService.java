package com.geneinsight.service;

import com.geneinsight.algorithms.stringmatching.KMP;
import com.geneinsight.algorithms.stringmatching.NaiveSearch;
import com.geneinsight.model.Result;
import com.geneinsight.algorithms.dp.LCS;

public class AlgorithmService {

    public Result runKMP(String text, String pattern) {
        KMP kmp = new KMP();
        return kmp.search(text, pattern); //  direct return
    }

    public Result runNaive(String text, String pattern) {
        return new NaiveSearch().search(text, pattern);
    }


    public void analyzeSimilarity(String dna1, String dna2) {

        String lcs = LCS.findLCSString(dna1, dna2);
        int lcsLength = lcs.length();

        double similarity = (2.0 * lcsLength) / (dna1.length() + dna2.length()) * 100;

        System.out.println("\n=== DNA Similarity Analysis ===");
        System.out.println("LCS: " + lcs);
        System.out.println("LCS Length: " + lcsLength);
        System.out.println("Similarity: " + similarity + "%");
    }

    public void compareAlgorithms(String text, String pattern) {

        Result kmpResult = runKMP(text, pattern);
        Result naiveResult = runNaive(text, pattern);

        System.out.println("\n=== Comparison Result ===");

        System.out.println("\nKMP:");
        kmpResult.display();

        System.out.println("\nNaive:");
        naiveResult.display();

        // Decide Winner (based on comparisons)
        System.out.println("\n--- Winner ---");

        if (kmpResult.getComparisons() < naiveResult.getComparisons()) {
            System.out.println("Winner: KMP ");
            System.out.println("Reason: Fewer comparisons (O(n + m))");
        } else if (kmpResult.getComparisons() > naiveResult.getComparisons()) {
            System.out.println("Winner: Naive");
            System.out.println("Reason: Fewer comparisons in this case");
        } else {
            System.out.println("Tie ");
        }
    }
}
