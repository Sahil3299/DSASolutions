class Solution {
      public int maximumPopulation(int[][] logs) {
        int[] pop = new int[101]; // 1950..2050
        for (int[] log : logs) {
            pop[log[0] - 1950]++;
            pop[log[1] - 1950]--;
        }
        int maxPop = 0, year = 1950, running = 0;
        for (int i = 0; i < 101; i++) {
            running += pop[i];
            if (running > maxPop) { maxPop = running; year = 1950 + i; }
        }
        return year;
    }
}