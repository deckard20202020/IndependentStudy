package Ebay;

public class adding {
    public static void main(String[] args) {

        int n = 54132;
        //int n = 30;
        int answer = addTheNumber(n);
        System.out.println(answer);
    }

    private static int addTheNumber(int n) {

        int sum = 0;
        String string = Integer.toString(n);

        for (int i = 0; i < string.length(); i++) {
            char digit = string.charAt(i);
            int num = Character.getNumericValue(digit);
            if (i % 2 == 0) {
                sum = sum + num;
            } else {
                sum = sum - num;
            }
        }

        return sum;
    }
}
