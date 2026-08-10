class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        for(int i = 0; i<n;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}