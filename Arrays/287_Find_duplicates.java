<<<<<<< HEAD
/*
Problem: Find the Duplicate Number (LeetCode #287)

Approach: Negative Marking
- Iterate through the array
- Use the value as an index
- Mark visited indices by making them negative
- If an index is already negative, that value is the duplicate

Time Complexity: O(n)
Space Complexity: O(1)  (modifies the input array)
*/

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);

            if (nums[a] < 0) {
                return a;   // duplicate found
            }

            nums[a] = -nums[a]; // mark as visited
        }

        return -1; // unreachable as per problem constraints
    }
}
=======
>>>>>>> 40f1843 (Add Solutions For LC:797)
