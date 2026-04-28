package com.geneinsight.controller;

import com.geneinsight.model.Result;
import com.geneinsight.service.AlgorithmService;
import com.geneinsight.utils.DNAUtils;
import com.geneinsight.utils.InputValidator;
import com.geneinsight.service.MutationService;
import com.geneinsight.service.DNAVisualizer;

import java.util.Scanner;

public class AppController {

    private final AlgorithmService service = new AlgorithmService();
    private final Scanner scanner = new Scanner(System.in);

    private String getValidDNA(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().toUpperCase().trim();

            if (InputValidator.isValidDNA(input)) {
                return input;
            }

            System.out.println("Invalid DNA sequence! Only A, C, G, T allowed.");
        }
    }

    public void start() {

        while (true) {
            System.out.println("\n=== GeneInsight Menu ===");
            System.out.println("1. Pattern Search (KMP)");
            System.out.println("2. Pattern Search (Naive)");
            System.out.println("3. Pattern Search (Rabin-Karp) 🔥");
            System.out.println("4. Compare Algorithms");
            System.out.println("5. DNA Complement & Reverse Complement ");
            System.out.println("6. DNA Similarity Analysis (LCS) ");
            System.out.println("7. Mutation Detection");
            System.out.println("8. DNA Alignment Visualizer ");
            System.out.println("9. Exit");

            System.out.print("Choose option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // clear wrong input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 9) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1->{
                    String dna = getValidDNA("Enter DNA Sequence: ");

                    String pattern = getValidDNA("Enter Pattern: ");

                    Result result = service.runKMP(dna, pattern);
                    System.out.println("\n--- RESULT ---");
                    result.display();
                }

                case 2->{
                    String dna = getValidDNA("Enter DNA Sequence: ");

                    String pattern = getValidDNA("Enter Pattern: ");

                    Result result = service.runNaive(dna, pattern);
                    System.out.println("\n--- RESULT ---");
                    result.display();
                }

                case 3 -> {
                    System.out.print("Enter DNA Sequence: ");
                    String text = scanner.nextLine();

                    System.out.print("Enter Pattern: ");
                    String pattern = scanner.nextLine();

                    Result result = service.runRabinKarp(text, pattern);

                    System.out.println("\n--- RESULT ---");
                    result.display();
                }

                case 4 -> {
                    String dna = getValidDNA("Enter DNA Sequence: ");

                    String pattern = getValidDNA("Enter Pattern: ");

                    service.compareAlgorithms(dna, pattern);
                }

                case 5 -> {
                    String dna = getValidDNA("Enter DNA Sequence: ");

                    String complement = DNAUtils.getComplement(dna);
                    String reverse = DNAUtils.getReverseComplement(dna);

                    System.out.println("\n--- DNA ANALYSIS ---");
                    System.out.println("Original: " + dna);
                    System.out.println("Complement: " + complement);
                    System.out.println("Reverse Complement: " + reverse);
                }

                case 6 -> {
                    String dna1 = getValidDNA("Enter DNA Sequence 1: ");

                    String dna2 = getValidDNA("Enter DNA Sequence 2: ");

                    service.analyzeSimilarity(dna1, dna2);
                }

                case 7 -> {
                    String dna1 = getValidDNA("Enter DNA Sequence 1: ");
                    String dna2 = getValidDNA("Enter DNA Sequence 2: ");

                    MutationService.detectMutation(dna1, dna2);
                }

                case 8 -> {

                    System.out.print("Enter DNA Sequence 1: ");
                    String dna1 = scanner.nextLine();

                    System.out.print("Enter DNA Sequence 2: ");
                    String dna2 = scanner.nextLine();

                    if (!InputValidator.isValidDNA(dna1) || !InputValidator.isValidDNA(dna2)) {
                        System.out.println("Invalid DNA!");
                        break;
                    }

                    DNAVisualizer.visualize(dna1, dna2);
                }

                default -> System.out.println("Invalid choice!");

            }
        }
    }
}
