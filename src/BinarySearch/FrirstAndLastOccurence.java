package BinarySearch;

public class FrirstAndLastOccurence {
    static int firstOccurence(int [] arr, int target){
         int low = 0;
         int high = arr.length - 1;
         int first = -1;
         while(low <= high ){
             int mid = low + (high - low)/2;
             if(arr[mid] == target){
                 first = mid;
                 high = mid - 1;
             } else if(arr[mid] < target){
                 low = mid + 1;
             } else {
                 high = mid - 1;
             }
         }
         return first;
    }
    static int lastOccurence(int [] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int last = -1;
        while (low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }
    public static void main(String[] args){
        int arr [] = {1, 2, 3, 3, 4, 4, 5, 5 , 5, 6, 6, 6, 7, 7, 7, 7, 7, 9};
        int target = 7;
        int first = firstOccurence(arr, target);
        if(first == -1){
            return new int[]{-1, -1};
        }
        int last = lastOccurence(arr, target);
        return new int[]{first, last};
    }
}
