class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];

            // Start a new subarray
            next[num % k]++;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {
                int nr = (int)((r * (long)num) % k);
                next[nr] += dp[r];
            }

            dp = next;

            // Add all subarrays ending here
            for (int r = 0; r < k; r++) {
                ans[r] += dp[r];
            }
        }

        return ans;
    }
}