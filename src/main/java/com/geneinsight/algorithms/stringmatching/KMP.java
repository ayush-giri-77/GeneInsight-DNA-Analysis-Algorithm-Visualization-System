package com.geneinsight.algorithms.stringmatching;

import com.geneinsight.model.Result;

import java.util.ArrayList;
import java.util.List;

public class KMP {

    public Result search(String text, String pattern) {

        long start = System.nanoTime();

        int n = text.length();
        int m = pattern.length();

        int[] lps = computeLPS(pattern);

        List<Integer> indices = new ArrayList<>();
        int comparisons = 0;

        int i = 0, j = 0;

        while (i < n) {

            comparisons++;

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    indices.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        long end = System.nanoTime();

        return new Result(indices, comparisons, (end - start), "KMP");
    }

    private int[] computeLPS(String pattern) {

        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}