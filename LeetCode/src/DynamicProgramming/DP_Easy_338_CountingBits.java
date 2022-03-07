package DynamicProgramming;

public class DP_Easy_338_CountingBits {
    public int[] countBits(int n) {

        //should be O(n) because we just traverse the array once

        int[] answer = new int[n+1];

        //base cases
        answer[0] = 0;
        if (n == 0) {
            return answer;
        }

        answer[1] = 1;
        if (n == 1) {
            return answer;
        }

        answer[2] = 1;
        if (n == 2) {
            return answer;
        }

        answer[3] = 2;
        if (n == 3) {
            return answer;
        }

        for (int i = 4; i <= n; i++) {
            //if it's even
            if ((i%2) == 0) {
                answer[i] = answer[i/2];
                //otherwise it's odd
            } else {
                //add a 1
                answer[i] = answer[i - 1] + 1;
            }
        }

        return answer;
    }
}
