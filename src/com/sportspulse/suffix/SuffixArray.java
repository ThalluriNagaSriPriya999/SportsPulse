package com.sportspulse.suffix;

import java.util.Arrays;

public class SuffixArray {

    private String text;
    private Integer[] suffixArray;

    public SuffixArray(String text) {

        this.text = text;

        buildSuffixArray();
    }

    private void buildSuffixArray() {

        int n = text.length();

        suffixArray = new Integer[n];

        for (int i = 0; i < n; i++) {
            suffixArray[i] = i;
        }

        Arrays.sort(
            suffixArray,
            (a, b) ->
                text.substring(a)
                    .compareTo(text.substring(b))
        );
    }

    public Integer[] getSuffixArray() {
        return suffixArray;
    }

    public void printSuffixArray() {

        System.out.println("\n========== SUFFIX ARRAY ==========");

        for (int i = 0; i < suffixArray.length; i++) {

            int position = suffixArray[i];

            System.out.println(
                position + " -> " +
                text.substring(position)
            );
        }
    }
}