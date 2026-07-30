class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '*') {
                // Pop the last character
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // Push non-star character
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}