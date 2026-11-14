package Arrays.Level_One;

import java.util.Arrays;

public class LeftRotatedByOne {
    static int[] leftRotatedByOne(int [] arr){
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++){
            arr[i -1] = arr[i];
        }
        arr[arr.length - 1] = temp;
        return arr;
    }
    public static void main(String[] args){
        int [] arr = {2, 3, 4, 5, 6, 7, 8, 9};
        leftRotatedByOne(arr);
        System.out.print(Arrays.toString(arr));
    }
}
