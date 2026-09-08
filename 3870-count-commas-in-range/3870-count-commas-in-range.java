// class Solution {
//     public int countCommas(int n) {
//        int digit;
//        int commas;
//        if(digit == 1 && digit == 3){
//         return 0;
//        }else if(digit == 4 && digit == 6){
//         return 2;
//        } else if(digit == 7 && digit == 9){
//         return 3;
//        }
//     return 0;
//     }
// }
class Solution {
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }
        return n - 999;
    }
}