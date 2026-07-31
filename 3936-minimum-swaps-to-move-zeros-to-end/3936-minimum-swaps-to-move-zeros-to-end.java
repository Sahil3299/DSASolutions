class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
        }
        
        int swaps = 0;
        // Check the last `zeroCount` elements
        for (int i = n - zeroCount; i < n; i++) {
            if (nums[i] != 0) {
                swaps++;
            }
        }
        
        return swaps;
    }
}