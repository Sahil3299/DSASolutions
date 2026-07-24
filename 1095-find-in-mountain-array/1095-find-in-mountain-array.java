/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index);
 *     public int length();
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndexInMountainArray(mountainArr);
        
        // Search in the ascending part
        int firstTry = orderAgnosticBS(mountainArr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        
        // Search in the descending part
        return orderAgnosticBS(mountainArr, target, peak + 1, mountainArr.length() - 1);
    }

    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                // Descending part of the mountain
                end = mid;
            } else {
                // Ascending part of the mountain
                start = mid + 1;
            }
        }
        return start; 
    }

    static int orderAgnosticBS(MountainArray mountainArr, int target, int start, int end) {
        // Evaluate the sort direction using the interface methods
        boolean isAsc = mountainArr.get(start) < mountainArr.get(end);
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            }
            
            if (isAsc) {
                if (target < midVal) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > midVal) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
