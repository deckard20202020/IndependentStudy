package BinarySearch;

public class BinarySearch_367_ValidPerfectSquare {
    public static void main(String[] args) {

        int num = 16;
        boolean answer = isPerfectSquare(num);
        System.out.println(answer);
    }

    private static boolean isPerfectSquare(int num) {

        int left = 1;

        //we don't need to start at the end
        int right = num/2;

        if (num == 1) {
            return true;
        }
        while(left <= right){

            int mid = left + (right - left) / 2;

            if (mid * mid == num){

                return true;

            } else if (num / mid > mid) {// to skip use of long we use num/mid

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return false;
    }
}
