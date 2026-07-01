class Solution {
       public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int lo = 0, hi = row.length - 1;
            while (lo <= hi) {
                int tmp = row[lo] ^ 1;
                row[lo] = row[hi] ^ 1;
                row[hi] = tmp;
                lo++; hi--;
            }
        }
        return image;
    }
}