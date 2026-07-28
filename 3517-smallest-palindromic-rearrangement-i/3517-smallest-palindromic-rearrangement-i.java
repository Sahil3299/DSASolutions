class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        StringBuilder half = new StringBuilder();
        char middle = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) middle = (char) ('a' + i);
            for (int j = 0; j < freq[i] / 2; j++) {
                half.append((char) ('a' + i));
            }
        }

        StringBuilder result = new StringBuilder(half);
        if (n % 2 == 1) result.append(middle);
        result.append(half.reverse());
        return result.toString();
    }
}