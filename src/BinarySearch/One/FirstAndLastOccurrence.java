package BinarySearch.One;

import java.util.Arrays;

public class FirstAndLastOccurrence {
    static int firstOccurence(int [] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int first = -1;
        while(low <= high){
            int mid = low + ( high - low)/2;
            if(arr[mid] == target){
                first = mid;
                high = mid - 1;
            } else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    static int lastOccurence(int [] arr, int target){
        int low =  0;
        int high = arr.length - 1;
        int last = -1;
        while(low <= high ){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                last = mid;
                low = mid + 1;
            } else if(arr[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }
    public static void main(String[] args){
        int [] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 8, 9, 9, 9};
        int target = 9;
        int first = firstOccurence(arr, target);
        int [] result;
        if(first == -1){
            result = new int [] {-1, -1};
        } else {
            int last = lastOccurence(arr, target);
            result = new int [] {first, last};
        }
        System.out.println(Arrays.toString(result));
    }
}
