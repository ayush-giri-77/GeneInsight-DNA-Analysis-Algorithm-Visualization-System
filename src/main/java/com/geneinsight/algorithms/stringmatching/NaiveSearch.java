package com.geneinsight.algorithms.stringmatching;

import com.geneinsight.model.Result;

import java.util.ArrayList;
import java.util.List;

public class NaiveSearch {

    public Result search(String text, String pattern) {

        long start = System.nanoTime();

        List<Integer> indices = new ArrayList<>();
        int comparisons = 0;

        for (int i = 0; i <= text.length() - pattern.length(); i++) {

            int j;
            for (j = 0; j < pattern.length(); j++) {
                comparisons++;
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == pattern.length()) {
                indices.add(i);
            }
        }

        long end = System.nanoTime();

        return new Result(indices, comparisons, (end - start));
    }
}
