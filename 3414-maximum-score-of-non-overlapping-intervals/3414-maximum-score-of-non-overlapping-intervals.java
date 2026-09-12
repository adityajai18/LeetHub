import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0); // start
            a[i][1] = intervals.get(i).get(1); // end
            a[i][2] = intervals.get(i).get(2); // weight
            a[i][3] = i;                       // original index
        }

        // Sort by ending time
        Arrays.sort(a, (x, y) -> x[1] - y[1]);

        long[][] dp = new long[n + 1][5];
        List<Integer>[][] path = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                path[i][k] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {

            int start = a[i - 1][0];
            int weight = a[i - 1][2];
            int index = a[i - 1][3];

            // Find previous non-overlapping interval
            int prev = 0;

            for (int j = i - 1; j > 0; j--) {
                if (a[j - 1][1] < start) {
                    prev = j;
                    break;
                }
            }

            for (int k = 1; k <= 4; k++) {

                // Don't take current interval
                dp[i][k] = dp[i - 1][k];
                path[i][k] = new ArrayList<>(path[i - 1][k]);

                // Take current interval
                long take = dp[prev][k - 1] + weight;

                if (take > dp[i][k]) {

                    dp[i][k] = take;
                    path[i][k] = new ArrayList<>(path[prev][k - 1]);
                    path[i][k].add(index);

                    Collections.sort(path[i][k]);

                } else if (take == dp[i][k]) {

                    List<Integer> temp =
                            new ArrayList<>(path[prev][k - 1]);

                    temp.add(index);
                    Collections.sort(temp);

                    if (isSmaller(temp, path[i][k])) {
                        path[i][k] = temp;
                    }
                }
            }
        }

        List<Integer> answer = path[n][1];

        for (int k = 2; k <= 4; k++) {

            if (dp[n][k] > dp[n][answer.size()]) {
                answer = path[n][k];

            } else if (dp[n][k] == dp[n][answer.size()]
                    && isSmaller(path[n][k], answer)) {
                answer = path[n][k];
            }
        }

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private boolean isSmaller(List<Integer> a, List<Integer> b) {

        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}