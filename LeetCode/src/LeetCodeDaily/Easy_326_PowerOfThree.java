package LeetCodeDaily;

public class Easy_326_PowerOfThree {
    public static void main(String[] args) {

        int n = 27;
        boolean answer = isPowerOfThree(n);
        System.out.println(answer);
    }

    private static boolean isPowerOfThree(int n) {

        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        while (n % 3 == 0) {

            n = n / 3;
        }

        return n == 1;
    }
}
