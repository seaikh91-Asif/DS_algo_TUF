package BinarySearch.Level_3;

public class FindNthRoot {
    static double multiply(double number, int n){
        double ans = 1.0;
        for(int i = 0; i <= n; i++){
            ans = ans * number;
        }
        return ans;
    }
    static double nthRoot(int n, int m){
        double low = 1;
        double high = m;
        double eps = 1e-6;

        while((high - low) > eps){
            double mid =  low + (high - low)/2.0;
            if(multiply(mid, n) < m){
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.print(low + " " + high);
    }
    public static void main(String[] args){

    }
}
