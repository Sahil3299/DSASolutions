class Solution {
    public boolean canJump(int[] nums) {
        int fastest =0;
        for( int i = 0;i< nums.length;i++){
            if(i > fastest){
                return false;
            }
            fastest = Math.max(fastest, i + nums[i]);
        }
        return true;
    }
}