class Solution {
    public int maxRepeating(String sequence, String word) {
        int k = 0;
        String pattern = word;
        while(sequence.contains(pattern)){
            k++;
            pattern += word;
        }
    return k;
    }
}