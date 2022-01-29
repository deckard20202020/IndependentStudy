public class problemJ_JumbledString {
    public static void main(String[]args){

//        3 4 2 1

//        01001
        int a = 3;
        int b = 4;
        int c = 2;
        int d = 1;
        int num0s;
        int num1s;

        if (a == 1) {
            num0s =2;
        } else if (a == 0) {
            num0s = 0;
        } else {
            num0s = numDoubles(a);
        }

        if (a == 1) {
            num0s =2;
        } else if (a == 0) {
            num0s = 0;
        } else {
            num0s = numDoubles(a);
        }
        //int num1s = numDoubles(d);

        System.out.println(num0s);
        //System.out.println(num1s);

        //find which one

    }

    private static int numDoubles(int a) {
        int doubles = 0;
        int r = 2;

        //C(n,r) = n! / r! (n – r)!

        int aFactorial = factorial(a);
        int rFactorial = 2;
        int aMinusRFactorial = factorial(a-2);

        doubles = aFactorial / (rFactorial * aMinusRFactorial);

        return doubles;
    }

    private static int factorial(int a) {

        int factorial = 1;

        for (int i = a; i > 1; i--) {
            factorial = factorial * i;
        }

        return factorial;

    }


}

