package sessions;/*

Not the most efficient but easier to understand.
Basic Idea: For any (i, j), I have to two choices (i) Take i (ii) or take j. 
In either case, the other player will try to maximize his score as well. 
My final score will be: My current step + rangeSum(i, j) - Other player's score. 
We'll try to maximize this final score at each step.

*/

class Solution {

    int[][] memoSum = null;
    int[] sumTill = null;

    public boolean PredictTheWinner(int[] nums) {

        this.memoSum = new int[nums.length][nums.length];
        
        //this will be used to calculate the range sum from i to j
        this.sumTill = new int[nums.length + 1];
        this.sumTill[0] = 0;
        for (int i = 0; i < sumTill.length - 1; i++) this.sumTill[i + 1] = this.sumTill[i] + nums[i];

        int max = maximise(nums, 0, nums.length - 1);
        int arraySum = rangeSum(0, nums.length - 1);
        return max >= arraySum - max;
    }
    
    int rangeSum(int i, int j) {

        return this.sumTill[j + 1] - this.sumTill[i];
    }
    
    int maximise(int[] nums, int i, int j) {

        if (i == j) {
            this.memoSum[i][j] = nums[i];
            return nums[i];
        }
        
        if (this.memoSum[i][j] != 0) return this.memoSum[i][j];
        int rs = rangeSum(i, j);
        int other1 = rs - maximise(nums, i + 1, j);
        int other2 = rs - maximise(nums, i, j - 1);
        this.memoSum[i][j] = other1 > other2 ? other1 : other2;
        return this.memoSum[i][j];
    }
}