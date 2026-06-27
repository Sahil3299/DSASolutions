class Solution {
     public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int lo = 0, hi = sorted.length - 1, pos = 0;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (sorted[mid] < nums[i]) { pos = mid + 1; lo = mid + 1; }
                else hi = mid - 1;
            }
            result[i] = pos;
        }
        return result;
    }

}