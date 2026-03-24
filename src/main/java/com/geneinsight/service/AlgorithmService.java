package com.geneinsight.service;

import com.geneinsight.algorithms.stringmatching.KMP;
import com.geneinsight.algorithms.stringmatching.NaiveSearch;
import com.geneinsight.model.Result;

import java.util.*;

public class AlgorithmService {


    public Result runKMP(String text, String pattern) {
        long start = System.nanoTime();

        int index = KMP.search(text, pattern);

        long end = System.nanoTime();

        List<Integer> matches = new ArrayList<>();
        if (index != -1) {
            matches.add(index);
        }

        int comparisons = 0; // KMP doesn't provide this in current design

        return new Result(matches, comparisons, end - start);
    }

    public Result runNaive(String text, String pattern) {
        return new NaiveSearch().search(text, pattern);
    }
}
