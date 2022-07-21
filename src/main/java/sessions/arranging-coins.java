package sessions;

/**
 * Binary search
 *
 * Here we need to find largest K that satisfies this equation K*(K+1)/2 <= N
 *
 * Time Complexity: O(logN) = be O(30) = O(1)
 *
 * Space Complexity: O(1)
 */

class MySolution {
    
    public int arrangeCoins(int n) {
        
        if (n == 1) {
            return 1;
        }
        
        if (n == 2){
            
            return 1;
        }
        
        if (n == 3) {
            return 2;
        }
        

        long start = 1, end = Integer.MAX_VALUE;
        
        while (start <= end) {
            
            long mid = start + (end - start) / 2;
            long coinsFilled = mid * (mid + 1) / 2;
            
            if (coinsFilled == n) {
                return (int) mid;
            }
            
            if (coinsFilled < n) {
                start = mid + 1;
            } 
            
            else {
                end = mid - 1;
            }
        }
        
        return (int) end;
    }
}