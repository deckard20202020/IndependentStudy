package LeetCodeDaily;

public class Easy_342_PowerOfFour {
    public static void main(String[] args) {

        int n = 16;
        boolean answer = isPowerOfFour(n);
        System.out.println(answer);
    }

    private static boolean isPowerOfFour(int n) {

        if (n == 1 || n == 4) {
            return true;
        }

        while (n > 4) {
            if (n % 4 != 0) {
                return false;
            }
            n = n /4;
            if (n == 4) {
                return true;
            }
        }

        return false;
    }


}
