package main.java.com.geneinsight.model;

import java.util.List;

public class Result {
    private List<Integer> indices;
    private int comparisons;
    private long timeTaken;
    private String algorithmName;

    public Result(List<Integer> indices, int comparisons, long timeTaken) {
        this.indices = indices;
        this.comparisons = comparisons;
        this.timeTaken = timeTaken;
        this.algorithmName = algorithmName;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public int getComparisons() {
        return comparisons;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }
}






