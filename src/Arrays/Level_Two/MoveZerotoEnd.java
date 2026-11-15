package Arrays.Level_Two;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZerotoEnd {
    static void Brute(int [] arr){
        List<Integer> myList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                myList.add(arr[i]);
            }
        }
        for(int i = 0; i < myList.size(); i++){
            arr[i] = myList.get(i);
        }
        int nz = myList.size();
        for(int i = 0; i < nz ; i++){
            arr[i] = 0;
        }
    }
    public static void main(String[] args){
        int [] arr = {2, 3, 5, 4, 6, 0, 0, 1, 2, 0, 2, 0, 1};
        Brute(arr);
        System.out.print(Arrays.toString(arr));
    }
}
