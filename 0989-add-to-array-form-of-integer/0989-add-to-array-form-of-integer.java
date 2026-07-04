class Solution {
     public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = k, i = num.length - 1;
        while (i >= 0 || carry > 0) {
            if (i >= 0) { carry += num[i--]; }
            result.addFirst(carry % 10);
            carry /= 10;
        }
        return result;
    }
}