class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        String s = String.valueOf(n);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '1' && c <= '9') {
                int digit = c - '0';
                x = x * 10 + digit; // Build the reconstructed number x
                sum += digit;       // Accumulate the digit sum
            }
        }
        
        return x * sum;
    }
}
