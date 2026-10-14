package com.sportspulse.string;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {

    public static List<Integer> search(String text, String pattern) {

        List<Integer> positions = new ArrayList<>();

        if (text == null || pattern == null ||
            pattern.isEmpty()) {
            return positions;
        }

        String combined = pattern + "$" + text;

        int[] z = new int[combined.length()];

        int left = 0;
        int right = 0;

        for (int i = 1; i < combined.length(); i++) {

            if (i <= right) {
                z[i] = Math.min(right - i + 1,
                        z[i - left]);
            }

            while (i + z[i] < combined.length() &&
                   combined.charAt(z[i]) ==
                   combined.charAt(i + z[i])) {

                z[i]++;
            }

            if (i + z[i] - 1 > right) {

                left = i;
                right = i + z[i] - 1;
            }
        }

        int patternLength = pattern.length();

        for (int i = 0; i < z.length; i++) {

            if (z[i] == patternLength) {

                positions.add(i - patternLength - 1);
            }
        }

        return positions;
    }
}