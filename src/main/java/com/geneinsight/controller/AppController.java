package com.geneinsight.controller;

import com.geneinsight.model.Result;
import com.geneinsight.service.AlgorithmService;

import java.util.Scanner;

public class AppController {

    private final AlgorithmService service = new AlgorithmService();

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GeneInsight Menu ===");
            System.out.println("1. Pattern Search (KMP)");
            System.out.println("2. Pattern Search (Naive)");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter DNA Sequence: ");
            String dna = sc.nextLine();

            System.out.print("Enter Pattern: ");
            String pattern = sc.nextLine();

            Result result = null;

            switch (choice) {
                case 1:
                    result = service.runKMP(dna, pattern);
                    break;
                case 2:
                    result = service.runNaive(dna, pattern);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            displayResult(result);
        }
    }

    private void displayResult(Result result) {
        System.out.println("\n--- RESULT ---");
        System.out.println("Match Positions: " + result.getIndices());
        System.out.println("Comparisons: " + result.getComparisons());
        System.out.println("Time (ns): " + result.getTimeTaken());
    }
}