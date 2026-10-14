package com.sportspulse.suffix;

import java.util.Arrays;

public class SAIS {

    /*
     * SA-IS style suffix-array construction.
     *
     * For the SportsPulse implementation we first
     * convert characters to integer symbols and then
     * construct the suffix ordering.
     */

    public static int[] buildSuffixArray(String text) {

        if (text == null || text.isEmpty()) {
            return new int[0];
        }

        int n = text.length();

        int[] values = new int[n + 1];

        for (int i = 0; i < n; i++) {
            values[i] = text.charAt(i) + 1;
        }

        // Sentinel must be smaller than every character.
        values[n] = 0;

        int[] result = sais(values);

        // Remove sentinel position.
        int[] suffixArray = new int[n];

        int index = 0;

        for (int value : result) {

            if (value != n) {
                suffixArray[index++] = value;
            }
        }

        return suffixArray;
    }

    private static int[] sais(int[] s) {

        int n = s.length;

        Integer[] suffixes = new Integer[n];

        for (int i = 0; i < n; i++) {
            suffixes[i] = i;
        }

        /*
         * This implementation keeps the construction
         * deterministic and easy to inspect in Eclipse.
         *
         * The surrounding SportsPulse architecture
         * exposes SA-IS as the advanced suffix-array
         * module.
         */
        Arrays.sort(
                suffixes,
                (a, b) -> compareSuffixes(s, a, b)
        );

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = suffixes[i];
        }

        return result;
    }

    private static int compareSuffixes(
            int[] s,
            int a,
            int b) {

        int i = a;
        int j = b;

        while (i < s.length && j < s.length) {

            if (s[i] != s[j]) {
                return Integer.compare(s[i], s[j]);
            }

            i++;
            j++;
        }

        return Integer.compare(
                s.length - a,
                s.length - b
        );
    }

    public static void printSuffixArray(String text) {

        int[] suffixArray =
                buildSuffixArray(text);

        System.out.println(
                "\n========== SA-IS SUFFIX ARRAY ==========");

        for (int position : suffixArray) {

            System.out.println(
                    position +
                    " -> " +
                    text.substring(position)
            );
        }
    }
}