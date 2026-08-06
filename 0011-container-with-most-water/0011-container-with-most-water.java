class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int hLeft = height[left];
            int hRight = height[right];
            
            int currentHeight = (hLeft < hRight) ? hLeft : hRight;
            int currentWater = (right - left) * currentHeight;
            
            if (currentWater > maxWater) {
                maxWater = currentWater;
            }
            
            if (hLeft < hRight) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}