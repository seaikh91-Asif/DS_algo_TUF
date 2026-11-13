package Arrays;

public class LinearSearch {
    static int LinearSearch(int [] arr, int n){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == n){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int [] arr = {2, 3, 4, 5, 6, 7, 8};
        int index =LinearSearch(arr,5);
        System.out.print(index);

    }
}
