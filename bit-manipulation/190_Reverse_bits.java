/*
Problem: Reverse Bits (LeetCode #190)

Approach:
Iterate through all 32 bits of the number.
For each bit:
- Shift result left
- Append the last bit of n
- Shift n right

Time Complexity: O(32) ≈ O(1)
Space Complexity: O(1)
*/

class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;          // make space
            result |= (n & 1);     // add last bit
            n >>= 1;               // move to next bit
        }

        return result;
    }
}
