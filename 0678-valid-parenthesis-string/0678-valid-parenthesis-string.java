class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                low++;
                high++;
            }
            else if (s.charAt(i) == ')') {
                low--;
                high--;
            }
            else { // '*'
                low--;
                high++;
            }

            if (high < 0) {
                return false;
            }

            low = Math.max(0, low);
        }

        return low == 0;
    }
}