/*

This solution uses a sliding window technique with two pointers and frequency maps.
We expand the window until all required characters are included, then shrink it to
find the minimum valid substring.

Time Complexity: O(n)  
Space Complexity: O(n)
*/

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> T = new HashMap<>();
        Map<Character, Integer> S = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            T.put(t.charAt(i), T.getOrDefault(t.charAt(i), 0) + 1);
        }

        int reqd = T.size();
        int l = 0, r = 0;
        int create = 0;
        int[] ans = { -1, 0, 0 };

        while (r < s.length()) {
            char c = s.charAt(r);
            S.put(c, S.getOrDefault(c, 0) + 1);

            if (T.containsKey(c) && S.get(c).intValue() == T.get(c).intValue()) {
                create++;
            }

            while (l <= r && create == reqd) {
                c = s.charAt(l);

                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                S.put(c, S.get(c) - 1);

                if (T.containsKey(c) && S.get(c) < T.get(c)) {
                    create--;
                }
                l++;
            }
            r++;
        }

        if (ans[0] == -1) {
            return "";
        }

        return s.substring(ans[1], ans[2] + 1);
    }
}