class Solution {
    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        
        long left = 0;
        long right = maxSum;
        long ans = 0;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (isPossible(n, index, maxSum, mid)) {
                ans = mid;
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }
        return (int) ans + 1;
    }
    
    private boolean isPossible(int n, int index, int maxSum, long target) {
        long countLeft = index;
        long countRight = n - 1 - index;
        
        long sum = target; 
        sum += getSum(countLeft, target);
        sum += getSum(countRight, target);
        
        return sum <= maxSum;
    }
    
    private long getSum(long count, long target) {
        if (count == 0) return 0;
        long peak = target - 1; 
        
        if (peak >= count) {
            
            return count * (2 * peak - count + 1) / 2;
        } else {
            return peak * (peak + 1) / 2;
        }
    }
}