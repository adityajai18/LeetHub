class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        backtrack(s, 0, 0, "", result);

        return result;
    }

    void backtrack(String s, int index, int parts,
                    String current, List<String> result) {

        // If 4 parts are created
        if (parts == 4) {
            // All digits must be used
            if (index == s.length()) {
                result.add(current.substring(0, current.length() - 1));
            }
            return;
        }

        // Try 1, 2, or 3 digits
        for (int len = 1; len <= 3; len++) {

            // Not enough characters
            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            // Leading zero
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            // Value greater than 255
            if (Integer.parseInt(part) > 255) {
                break;
            }

            backtrack(
                s,
                index + len,
                parts + 1,
                current + part + ".",
                result
            );
        }
    }
}