package BinarySearch.One;

import java.util.Arrays;

public class RotatedSorted_1 {
    public static int search(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == target){
                return mid;
            }

            //Cheackin the left side of the array:
            if(arr[low] <= arr[mid]){
                if(target >= arr[low] && arr[mid] >= target){
                    high = mid - 1;
                } else{
                    low = mid + 1;
                }
            } //if not then definetly in the right side thats why no condition needed
             else{
                if(target >= arr[mid] && arr[high] >= target ){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        // 1. Standard rotated arrays (Target present)
        runTest(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4);      // Target in right half
        runTest(new int[]{4, 5, 6, 7, 0, 1, 2}, 5, 1);      // Target in left half
        runTest(new int[]{4, 5, 6, 7, 0, 1, 2}, 4, 0);      // Target at index 0 (first element)
        runTest(new int[]{4, 5, 6, 7, 0, 1, 2}, 2, 6);      // Target at last index
        runTest(new int[]{4, 5, 6, 7, 0, 1, 2}, 7, 3);      // Target is the pivot (max element)

        // 2. Target NOT present
        runTest(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1);     // Missing in middle range
        runTest(new int[]{4, 5, 6, 7, 0, 1, 2}, 10, -1);    // Greater than max
        runTest(new int[]{4, 5, 6, 7, 0, 1, 2}, -5, -1);    // Smaller than min

        // 3. Array NOT rotated at all (already sorted)
        runTest(new int[]{1, 2, 3, 4, 5, 6}, 4, 3);
        runTest(new int[]{1, 2, 3, 4, 5, 6}, 7, -1);

        // 4. Edge cases: Single element
        runTest(new int[]{1}, 1, 0);
        runTest(new int[]{1}, 0, -1);

        // 5. Edge cases: Two elements (Rotated & Not rotated)
        runTest(new int[]{3, 1}, 1, 1);
        runTest(new int[]{3, 1}, 3, 0);
        runTest(new int[]{1, 3}, 3, 1);
        runTest(new int[]{3, 1}, 2, -1);

        // 6. Negative numbers
        runTest(new int[]{5, 10, -10, -5, 0, 2}, -5, 3);
        runTest(new int[]{5, 10, -10, -5, 0, 2}, 10, 1);

        int [] arr = {  4, 5, 6, 7, 8, 9,1, 2, 3};
        int target = 9;
        int ans = search(arr, target);
        System.out.print(ans);
    }
    private static void runTest(int[] nums, int target, int expected) {
        int actual = search(nums, target);
        String status = (actual == expected) ? "PASS" : "FAIL";
        System.out.printf("[%s] nums=%s, target=%d | Expected: %d, Got: %d%n", status, Arrays.toString(nums), target, expected, actual);
    }
}
