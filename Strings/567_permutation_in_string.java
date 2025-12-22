/*
Problem: Permutation in String (LeetCode #567)

Approach: Sliding Window + Frequency Count
- Use two frequency arrays of size 26 for characters 'a' to 'z'
- Initialize frequency maps for s1 and the first window of s2
- Slide the window over s2, updating counts
- At each step, compare the two frequency maps

Time Complexity: O(26 * n) ≈ O(n)
Space Complexity: O(26) ≈ O(1)
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        // Initialize frequency maps
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        // Slide the window over s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {

            if (matches(s1Map, s2Map)) {
                return true;
            }

            // Add new character to window
            s2Map[s2.charAt(i + s1.length()) - 'a']++;

            // Remove old character from window
            s2Map[s2.charAt(i) - 'a']--;
        }

        // Check the last window
        return matches(s1Map, s2Map);
    }

    // Helper method to compare two frequency arrays
    private boolean matches(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }
}
