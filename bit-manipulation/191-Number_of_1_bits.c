/*
Problem: Number of 1 Bits (Hamming Weight) – LeetCode #191

Approach:
Check the last bit using bitwise AND.
If it is 1, increment the count.
Right shift the number until it becomes 0.

Time Complexity: O(32) ≈ O(1)
Space Complexity: O(1)
*/

int hammingWeight(int n) {
    int count = 0;

    while (n != 0) {
        count += (n & 1);
        n >>= 1;
    }

    return count;
}
