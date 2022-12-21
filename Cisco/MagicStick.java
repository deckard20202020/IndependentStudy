package Cisco;

public class MagicStick {
    public static void main (String[] args) {
        int[] sticks = {1,2,3};
        int[] cost = {20, 30, 40};
        int answer = findCost(sticks, cost);
        System.out.println(answer);
    }

    private static int findCost(int[] sticks, int[] cost) {

        //This is n^2  There has to be a faster way
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < sticks.length; i++) {
            int total = 0;
            int size = sticks[i];

            for (int j = 0; j < sticks.length; j++) {
                int temp = sticks[j];

                while(temp < size) {
                    temp++;
                    total = total + cost[j];
                }

                while (temp > size) {
                    temp--;
                    total = total + cost[j];
                }
            }

            answer = Math.min(answer, total);
        }

        return answer;
    }
}
