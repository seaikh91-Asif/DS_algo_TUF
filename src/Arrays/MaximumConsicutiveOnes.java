package Arrays;
import java.util.Arrays;

public class MaximumConsicutiveOnes {
    static int maximumconsicuctiveones(int [] arrr){
        int max = 0;
        int count = 0;
        for(int i = 0; i < arrr.length; i++){
            if(arrr[i] == 1){
                count++;
                max = Math.max(count, max);
            } else {
                count = 0;
            }
        }
        return max;
    }
    public static void main(String[] args){
        int [] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0};
        int ans = maximumconsicuctiveones(arr);
        System.out.print(ans);
    }
}
