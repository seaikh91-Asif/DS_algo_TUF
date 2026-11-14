package Arrays.Level_One;

public class LargestElement {
    static int LargestElement(int [] arr){
        int largest = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }
    public static void main(String[] args){
        int [] arr = {2, 3, 4, 5, 6, 7, 8};
        int ans = LargestElement(arr);
        System.out.print(ans);
    }
}
