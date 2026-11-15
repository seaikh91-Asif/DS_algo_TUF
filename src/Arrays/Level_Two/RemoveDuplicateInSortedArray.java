package Arrays.Level_Two;

public class RemoveDuplicateInSortedArray {
    static int removeDuplicateFromSrotedArray(int [] arr){
        int i = 0;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] != arr[i]){
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return (i + 1);
    }
    public static void main(String[] args){
        int [] arr = { 1, 1, 2, 2 ,2, 3, 3, 4, 4, 5, 6, 7, 8};
        int ans = removeDuplicateFromSrotedArray(arr);
        System.out.print(ans);
    }
}
