package com.geneinsight.algorithms.stringmatching;

import com.geneinsight.model.Result;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {

    private final int d = 256; // number of characters
    private final int q = 101; // prime number

    public Result search(String text, String pattern) {

        long start = System.nanoTime();

        int n = text.length();
        int m = pattern.length();

        List<Integer> indices = new ArrayList<>();
        int comparisons = 0;

        int p = 0; // hash for pattern
        int t = 0; // hash for text
        int h = 1;

        // compute h = pow(d, m-1) % q
        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;

        // initial hash
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        for (int i = 0; i <= n - m; i++) {

            // hash match
            if (p == t) {

                // verify characters
                int j;
                for (j = 0; j < m; j++) {
                    comparisons++;
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                if (j == m) {
                    indices.add(i);
                }
            }

            // roll hash
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;

                if (t < 0)
                    t += q;
            }
        }

        long end = System.nanoTime();

        return new Result(indices, comparisons, (end - start), "Rabin-Karp");
    }
}