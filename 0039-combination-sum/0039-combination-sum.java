class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        // Base Case 1: Found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Base Case 2: Exceeded the target sum
        if (target < 0) {
            return;
        }

        // Explore all available candidates starting from 'start'
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]); // Choose
            backtrack(candidates, target - candidates[i], i, current, result); // Explore (stay at index 'i' to allow reuse)
            current.remove(current.size() - 1); // Backtrack
        }
    }
}