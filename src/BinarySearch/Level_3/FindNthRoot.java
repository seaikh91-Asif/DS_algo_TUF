package BinarySearch.Level_3;

public class FindNthRoot {

    static double multiply(double number, int n) {
        double ans = 1.0;

        for (int i = 0; i < n; i++) {
            ans = ans * number;
        }
        return ans;
    }

    static double nthRoot(int n, int m) {
        double low = 1.0;
        double high = m;
        double eps = 1e-6;

        while ((high - low) > eps) {
            double mid = low + (high - low) / 2.0;
            if (multiply(mid, n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }


        return low;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 27;
        double result = nthRoot(n, m);


        System.out.printf("%dth root of %d is: %.6f%n", n, m, result);
    }
}