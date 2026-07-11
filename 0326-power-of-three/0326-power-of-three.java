class Solution {
    public boolean isPowerOfThree(int n) {
        // 1. Guard against 0, negative numbers, and numbers not divisible by 3
        if (n <= 0) {
            return false;
        }
        // 2. Base case: 3^0 = 1 (A true power of 3)
        if (n == 1) {
            return true;
        }
        // 3. Base case: If it's not cleanly divisible by 3, it's not a power of 3
        if (n % 3 != 0) {
            return false;
        }
        
        // 4. Recursive Step: Divide and pass down the call stack
        return isPowerOfThree(n / 3);
    }
}
