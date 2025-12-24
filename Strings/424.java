/*
Problem: Longest Repeating Character Replacement (LeetCode #424)

Approach: Sliding Window
- Use two pointers (left, right)
- Maintain frequency of characters in current window
- Track the count of the most frequent character
- Shrink window when replacements needed exceed k

Time Complexity: O(n)
Space Complexity: O(26) ≈ O(1)
hello
*/

class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int[] occur = new int[26];
        int maxCount = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            maxCount = Math.max(
                maxCount,
                ++occur[s.charAt(right) - 'A']
            );

            if ((right - left + 1) - maxCount > k) {
                occur[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
