class Solution {
    public int maxProfit(int[] prices) {
        int minPrize = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if(price < minPrize){
                minPrize = price;

            }else if(price-minPrize > maxProfit){
                maxProfit = price - minPrize;
            }
        }
        return maxProfit;
    }
}