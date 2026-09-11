class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;

        for (int num = 100; num <= 998; num++) {

            // Number must be even
            if (num % 2 != 0) {
                continue;
            }

            int[] freq = new int[10];

            // Count available digits
            for (int digit : digits) {
                freq[digit]++;
            }

            int n = num;

            // Extract hundreds, tens and ones digits
            int ones = n % 10;
            n /= 10;

            int tens = n % 10;
            n /= 10;

            int hundreds = n;

            // Check whether required digits are available
            if (freq[hundreds] > 0) {
                freq[hundreds]--;

                if (freq[tens] > 0) {
                    freq[tens]--;

                    if (freq[ones] > 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}