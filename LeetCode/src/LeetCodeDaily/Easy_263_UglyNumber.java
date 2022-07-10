package LeetCodeDaily;

public class Easy_263_UglyNumber {
    public static void main(String[] args) {
        int n = 6;
        boolean answer = isUgly(n);
        System.out.println(answer);
    }

    private static boolean isUgly(int n) {

        //base cases
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        while(n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }

        return true;
    }
}
