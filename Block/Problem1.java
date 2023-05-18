package Block;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public static void main(String[] args) {
        int n = 123456;
        int answer = digitsManipulations(n);
        System.out.print(answer);
    }

    private static int digitsManipulations(int n) {
        List<Integer> listOfDigits = getListOfDigits(n);

        int product = getProduct(listOfDigits);
        int sum = getSum(listOfDigits);

        return product - sum;
    }

    private static int getSum(List<Integer> listOfDigits) {
        int sum = 0;

        for (Integer n : listOfDigits) {
            sum = sum + n;
        }

        return sum;
    }

    private static int getProduct(List<Integer> listOfDigits) {
        int product = 1;

        for (Integer n : listOfDigits) {
            product = product * n;
        }

        return product;
    }

    private static List<Integer> getListOfDigits(int n) {
        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            int numToAdd = n % 10;
            list.add(numToAdd);
            n = n / 10;
        }

        return list;
    }
}
