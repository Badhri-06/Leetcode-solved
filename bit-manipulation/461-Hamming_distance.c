/*
Problem: Hamming Distance (LeetCode #461)

Approach:
1. XOR the two numbers to find differing bits.
2. Count the number of set bits in the result using bit manipulation.

Time Complexity: O(32) ≈ O(1)
Space Complexity: O(1)
*/


int hammingDistance(int x, int y) {
    int n=x^y;
int count  =0 ;
 while(n != 0){
 int last = n & 1 ; // &1 -> to fetch last one bit of a number binary  
 if( last == 1 )    
   count++;
n>>=1; // >>1 -> to remove last one bit in a numbers binary 
 }
return count;
}


    
