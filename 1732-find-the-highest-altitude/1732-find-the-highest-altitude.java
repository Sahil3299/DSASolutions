class Solution {
    public int largestAltitude(int[] gain) {
     int maxAlt = 0 ,current =0;
    for(int g : gain){
        current += g;
        maxAlt = Math.max(maxAlt,current);
    }
    return maxAlt;
    }
}