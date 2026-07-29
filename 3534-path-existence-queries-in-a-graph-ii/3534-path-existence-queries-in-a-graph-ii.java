class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] idxBoxed = new Integer[n];
        for (int i = 0; i < n; i++) idxBoxed[i] = i;
        Arrays.sort(idxBoxed, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] pos = new int[n];   // pos[original index] -> sorted position
        int[] val = new int[n];   // val[sorted position] -> value
        for (int k = 0; k < n; k++) {
            pos[idxBoxed[k]] = k;
            val[k] = nums[idxBoxed[k]];
        }

        // Component id via consecutive-gap grouping
        int[] compId = new int[n];
        for (int k = 1; k < n; k++) {
            compId[k] = (val[k] - val[k - 1] <= maxDiff) ? compId[k - 1] : compId[k - 1] + 1;
        }

        // R[k] = furthest sorted position reachable in exactly one hop
        int[] R = new int[n];
        int right = 0;
        for (int k = 0; k < n; k++) {
            if (right < k) right = k;
            while (right + 1 < n && val[right + 1] - val[k] <= maxDiff) right++;
            R[k] = right;
        }

        // Binary lifting table: up[p][k] = position reachable using <= 2^p hops
        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        LOG++;
        int[][] up = new int[LOG][n];
        up[0] = R;
        for (int p = 1; p < LOG; p++) {
            for (int k = 0; k < n; k++) {
                up[p][k] = up[p - 1][up[p - 1][k]];
            }
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int u = queries[i][0], v = queries[i][1];
            int pu = pos[u], pv = pos[v];
            if (pu == pv) { ans[i] = 0; continue; }
            if (compId[pu] != compId[pv]) { ans[i] = -1; continue; }

            int lo = Math.min(pu, pv), hi = Math.max(pu, pv);
            int cur = lo, hops = 0;
            for (int p = LOG - 1; p >= 0; p--) {
                if (up[p][cur] < hi) {
                    cur = up[p][cur];
                    hops += (1 << p);
                }
            }
            ans[i] = hops + 1; // final hop always covers hi, guaranteed by same-component check
        }
        return ans;
    }
}