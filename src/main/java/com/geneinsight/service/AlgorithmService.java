package main.java.com.geneinsight.service;

import com.geneinsight.algorithms.stringmatching.KMP;
import com.geneinsight.algorithms.stringmatching.NaiveSearch;
import com.geneinsight.model.Result;

public class AlgorithmService {

    public Result runKMP(String text, String pattern) {
        return new KMP().search(text, pattern);
    }

    public Result runNaive(String text, String pattern) {
        return new NaiveSearch().search(text, pattern);
    }
}
