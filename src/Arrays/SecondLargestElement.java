package Arrays;

public class SecondLargestElement {
    static int secondLargest(int[] arr){
        int sLargest = arr[0];
        int largest = -1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > largest){
                sLargest = largest;
                largest = arr[i];
            } else if(arr[i] < largest && arr[i] > sLargest){
                sLargest = arr[i];
            }
        }
        return sLargest;
    }
    public static void main(String[] args){
        int [] arr = { 2,5 ,44 ,1, 5, 7, 8, 9};
        int ans = secondLargest(arr);
        System.out.print(ans);

    }
}
