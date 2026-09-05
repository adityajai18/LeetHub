class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        // Maximum from left
        maxLeft[0] = nums[0];

        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }

        // Minimum from right
        minRight[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }

        // Find first stable index
        for (int i = 0; i < n; i++) {
            if (maxLeft[i] - minRight[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}