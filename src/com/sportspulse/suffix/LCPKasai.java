package com.sportspulse.suffix;

public class LCPKasai {

    public static int[] buildLCP(
            String text,
            Integer[] suffixArray) {

        int n = text.length();

        int[] rank = new int[n];
        int[] lcp = new int[n];

        for (int i = 0; i < n; i++) {

            rank[suffixArray[i]] = i;
        }

        int k = 0;

        for (int i = 0; i < n; i++) {

            int currentRank = rank[i];

            if (currentRank == 0) {
                continue;
            }

            int previousSuffix =
                    suffixArray[currentRank - 1];

            while (
                i + k < n &&
                previousSuffix + k < n &&
                text.charAt(i + k) ==
                text.charAt(previousSuffix + k)
            ) {

                k++;
            }

            lcp[currentRank] = k;

            if (k > 0) {
                k--;
            }
        }

        return lcp;
    }

    public static void printLCP(
            String text,
            Integer[] suffixArray) {

        int[] lcp =
                buildLCP(text, suffixArray);

        System.out.println(
                "\n========== LCP / KASAI ==========");

        for (int i = 0; i < lcp.length; i++) {

            System.out.println(
                "Suffix: " +
                suffixArray[i] +
                " | LCP: " +
                lcp[i]
            );
        }
    }
}