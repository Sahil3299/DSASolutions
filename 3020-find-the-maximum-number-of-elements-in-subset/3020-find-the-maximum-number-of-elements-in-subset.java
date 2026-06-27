class Solution {
    public int maximumLength(int[] nums) {
          Map<Long, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put((long) num, countMap.getOrDefault((long) num, 0) + 1);
        }

        int maxLen = 1;

        // Step 2: Handle special case for number 1
        if (countMap.containsKey(1L)) {
            int countOne = countMap.get(1L);
            // Must be an odd length sequence
            if (countOne % 2 == 0) {
                maxLen = Math.max(maxLen, countOne - 1);
            } else {
                maxLen = Math.max(maxLen, countOne);
            }
        }

        // Step 3: Iterate through each unique element as a potential base x > 1
        for (long x : countMap.keySet()) {
            if (x == 1) continue;

            int currentLen = 0;
            long currentNum = x;

            // Chain upwards while we have at least 2 copies of the current number
            while (countMap.containsKey(currentNum) && countMap.get(currentNum) >= 2) {
                currentLen += 2;
                currentNum = currentNum * currentNum; // x^2, x^4, x^8...
            }

            // If the stopping number exists at least once, it can serve as the peak element
            if (countMap.containsKey(currentNum) && countMap.get(currentNum) >= 1) {
                currentLen += 1;
            } else {
                // If the peak element is missing, we must subtract 1 from the tail to make a valid peak
                currentLen -= 1;
            }

            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}