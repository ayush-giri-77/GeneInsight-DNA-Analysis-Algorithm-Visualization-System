package com.geneinsight.service;

import com.geneinsight.algorithms.stringmatching.KMP;
import com.geneinsight.algorithms.stringmatching.NaiveSearch;
import com.geneinsight.algorithms.stringmatching.RabinKarp;
import com.geneinsight.algorithms.dp.LCS;
import com.geneinsight.model.Result;

public class AlgorithmService {

    public Result runKMP(String text, String pattern) {
        return new KMP().search(text, pattern);
    }

    public Result runNaive(String text, String pattern) {
        return new NaiveSearch().search(text, pattern);
    }

    public Result runRabinKarp(String text, String pattern) {
        return new RabinKarp().search(text, pattern);
    }

    public void analyzeSimilarity(String dna1, String dna2) {

        String lcs = LCS.findLCSString(dna1, dna2);
        int lcsLength = lcs.length();

        double similarity = (2.0 * lcsLength) / (dna1.length() + dna2.length()) * 100;

        System.out.println("\n=== DNA Similarity Analysis ===");
        System.out.println("LCS: " + lcs);
        System.out.println("LCS Length: " + lcsLength);
        System.out.printf("Similarity: %.2f%%\n", similarity); // cleaner formatting
    }

    public void compareAlgorithms(String text, String pattern) {

        Result kmp = runKMP(text, pattern);
        Result naive = runNaive(text, pattern);
        Result rk = runRabinKarp(text, pattern);

        System.out.println("\n=== Comparison Result ===");

        System.out.println("\nKMP:");
        kmp.display();

        System.out.println("\nNaive:");
        naive.display();

        System.out.println("\nRabin-Karp:");
        rk.display();

        // ✅ Find best (clean approach)
        Result best = kmp;

        if (naive.getComparisons() < best.getComparisons()) {
            best = naive;
        }
        if (rk.getComparisons() < best.getComparisons()) {
            best = rk;
        }

        // ✅ Check ties
        int bestComp = best.getComparisons();

        boolean kmpTie = kmp.getComparisons() == bestComp;
        boolean naiveTie = naive.getComparisons() == bestComp;
        boolean rkTie = rk.getComparisons() == bestComp;

        System.out.println("\n--- Winner ---");

        if ((kmpTie && naiveTie && rkTie)) {
            System.out.println("Tie between KMP, Naive, and Rabin-Karp 🤝");
        }
        else if (kmpTie && naiveTie) {
            System.out.println("Tie between KMP and Naive 🤝");
        }
        else if (kmpTie && rkTie) {
            System.out.println("Tie between KMP and Rabin-Karp 🤝");
        }
        else if (naiveTie && rkTie) {
            System.out.println("Tie between Naive and Rabin-Karp 🤝");
        }
        else {
            System.out.println("Winner: " + best.getAlgorithmName() + " 🚀");

            // Reason based on algorithm
            switch (best.getAlgorithmName()) {
                case "KMP" ->
                        System.out.println("Reason: Uses prefix table (O(n + m))");
                case "Rabin-Karp" ->
                        System.out.println("Reason: Hashing reduces comparisons");
                case "Naive" ->
                        System.out.println("Reason: Performed best for this input");
            }
        }
    }
}