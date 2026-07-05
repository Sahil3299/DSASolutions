class Solution {
   public int[] sumZero(int n) {
    int[] result = new int[n];
    int left = 0, right = n - 1;
    
    while (left < right) {
        result[left] = -right;
        result[right] = right;
        left++;
        right--;
    }
    return result;
}

}