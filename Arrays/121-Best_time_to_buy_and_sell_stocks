/*
Problem: Best Time to Buy and Sell Stock (LeetCode #121)

Approach:
Track the minimum price so far.
At each step, calculate profit by selling on that day.
Update the maximum profit accordingly.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i];
            }
            profit=Math.max(profit,prices[i]-min);
        }
        return profit;
        
    }
}