package Citadel;

import java.util.ArrayList;
import java.util.List;

public class maxLength {
    public static void main(String[] ans) {
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(2);
        a.add(1);
        a.add(4);

        int k = 4;

        int answer = findMaxLength(a, k);
        System.out.println(answer);
    }

    private static int findMaxLength(List<Integer> a, int k) {

        int answer = 0;
        int l = a.size();
        int sum = 0;
        for (int i = 0; i < l; i++) {
            sum = a.get(i);
            for (int j = i; j <l; j++) {
                sum = sum + a.get(j);
                if (sum <= k) {
                    answer = Math.max(answer, j = i + 1);
                }
            }
        }

        return answer;
    }
}
