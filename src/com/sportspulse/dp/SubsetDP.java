package com.sportspulse.dp;

public class SubsetDP {

    /*
     * Determines whether a subset of the given values
     * can produce the target sum.
     */
    public static boolean canFormTarget(
            int[] values,
            int target) {

        if (target < 0) {
            return false;
        }

        boolean[][] dp =
                new boolean[values.length + 1][target + 1];

        // Target 0 can always be formed
        dp[0][0] = true;

        for (int i = 1; i <= values.length; i++) {

            dp[i][0] = true;

            for (int sum = 1; sum <= target; sum++) {

                // Do not select current value
                dp[i][sum] = dp[i - 1][sum];

                // Select current value if possible
                if (sum >= values[i - 1]) {

                    dp[i][sum] =
                            dp[i][sum]
                            || dp[i - 1]
                            [sum - values[i - 1]];
                }
            }
        }

        return dp[values.length][target];
    }

    /*
     * Prints the complete DP table.
     */
    public static void printDPTable(
            int[] values,
            int target) {

        boolean[][] dp =
                new boolean[values.length + 1][target + 1];

        dp[0][0] = true;

        for (int i = 1; i <= values.length; i++) {

            dp[i][0] = true;

            for (int sum = 1; sum <= target; sum++) {

                dp[i][sum] = dp[i - 1][sum];

                if (sum >= values[i - 1]) {

                    dp[i][sum] =
                            dp[i][sum]
                            || dp[i - 1]
                            [sum - values[i - 1]];
                }
            }
        }

        System.out.println(
                "\n========== SUBSET DP TABLE =========="
        );

        System.out.print("       ");

        for (int sum = 0; sum <= target; sum++) {
            System.out.printf("%5d", sum);
        }

        System.out.println();

        for (int i = 0; i <= values.length; i++) {

            if (i == 0) {
                System.out.print("None   ");
            } else {
                System.out.printf(
                        "%-7d",
                        values[i - 1]
                );
            }

            for (int sum = 0; sum <= target; sum++) {

                System.out.printf(
                        "%5s",
                        dp[i][sum] ? "T" : "F"
                );
            }

            System.out.println();
        }
    }
}