class Solution {
   public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) != '0') return false;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int reachableCount = 0; // # of true dp[i] in the sliding window [i-maxJump, i-minJump]
        for (int i = 1; i < n; i++) {
            if (i >= minJump) reachableCount += dp[i - minJump] ? 1 : 0;
            if (i > maxJump) reachableCount -= dp[i - maxJump - 1] ? 1 : 0;
            dp[i] = s.charAt(i) == '0' && reachableCount > 0;
        }
        return dp[n - 1];
    }
}