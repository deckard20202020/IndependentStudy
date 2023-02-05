package iBoss;

public class Problem1 {
    public static void main(String[] args) {
        String input = "XX--";

        char start = input.charAt(0);
        double totalLength = input.length();
        double counter = 0;


        String transferSpeedString = "1000";
        double tranferSpeed = Integer.valueOf(transferSpeedString);


        for (int i = 0; i < totalLength; i++) {
            if (input.charAt(i) == start) {
                counter++;
            }
        }

        counter = counter * 100;
        totalLength = totalLength * 100;
        double answer = counter / totalLength;
        answer = answer * 100;
        int intValue = (int) answer;

        System.out.println(intValue);
    }
}
