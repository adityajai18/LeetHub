class Solution {
    public int minSumOfLengths(int[] arr, int target) {
    
        int n = arr.length;
        int[] best = new int[n];

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target && left <= right) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int length = right - left + 1;

                // Check if there is a previous non-overlapping subarray
                if (left > 0 && best[left - 1] != 0) {
                    answer = Math.min(answer, length + best[left - 1]);
                }

                minLength = Math.min(minLength, length);
            }

            // Store the shortest subarray found up to this index
            best[right] = minLength == Integer.MAX_VALUE ? 0 : minLength;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}   
    
