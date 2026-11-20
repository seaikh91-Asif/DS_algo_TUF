package BinarySearch;

import java.util.Arrays;
import java.util.Random;

public class RotedSorted_2 {


    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(mid == target){
                return mid;
            }
            if(arr[low] <= arr[mid]){
                if(arr[low] <= target && target <= arr[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(target >= arr[mid] && arr[high] >= target){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // Brute force reference (minimum element ber korar jonno)
    private static int bruteForceMin(int[] arr) {
        int min = arr[0];
        for (int x : arr) {
            if (x < min) min = x;
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] testArrays = {
                // 1. Tricky Duplicate Cases (low == mid == high)
                {1, 0, 1, 1, 1},
                {1, 3, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 3, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 0, 2, 2},
                {2, 2, 2, 0, 0, 1, 2, 2},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {5, 5, 5, 1, 2, 5, 5},

                // 2. Pivot at Very Start or Very End
                {5, 1, 2, 3, 4},
                {2, 3, 4, 5, 1},
                {3, 1, 1},
                {1, 1, 3},
                {1, 3, 1},
                {3, 3, 1, 3},
                {3, 1, 3, 3},

                // 3. Standard Rotated
                {4, 5, 6, 6, 7, 0, 1, 2, 4, 4},
                {2, 5, 6, 0, 0, 1, 2},

                // 4. Not Rotated (0 rotation)
                {1, 2, 2, 3, 4, 4, 5},
                {1, 2, 3, 4, 5},

                // 5. Negative Numbers
                {0, 1, 1, -5, -4, -4, -1, 0},
                {-2, -2, -2, -5, -4, -3, -2},
                {-10, -10, -10, -10},

                // 6. Small Arrays (1 & 2 Elements)
                {1},
                {3, 1},
                {1, 3},
                {2, 2}
        };

        int passed = 0;
        for (int i = 0; i < testArrays.length; i++) {
            int expected = bruteForceMin(testArrays[i]);
            int actual = search(testArrays[i]);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf("FAIL Test %2d | Expected: %3d | Got: %3d | Array: %s%n",
                        (i + 1), expected, actual, Arrays.toString(testArrays[i]));
            }
        }
        System.out.println("Manual Tests Passed: " + passed + " / " + testArrays.length);

        // --- 10,000 RANDOM STRESS TESTS ---
        Random rand = new Random(42);
        int stressTests = 10000;
        int stressPassed = 0;

        for (int t = 1; t <= stressTests; t++) {
            int n = rand.nextInt(30) + 1;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(11) - 5; // -5 to 5 (lots of duplicates)
            }
            Arrays.sort(arr);

            int k = rand.nextInt(n);
            int[] rotated = new int[n];
            for (int i = 0; i < n; i++) {
                rotated[i] = arr[(i + k) % n];
            }

            int expected = bruteForceMin(rotated);
            int actual = search(rotated);

            if (actual == expected) {
                stressPassed++;
            } else {
                System.out.printf("STRESS FAIL #%d | Expected: %d | Got: %d | Array: %s%n",
                        t, expected, actual, Arrays.toString(rotated));
                break;
            }
        }
        System.out.println("Stress Tests Passed: " + stressPassed + " / " + stressTests);
    }
}