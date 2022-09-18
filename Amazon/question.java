package Amazon;

import java.util.ArrayList;
import java.util.List;

public class question {
    public static void main(String[] args) {
        List<Integer> ratings = new ArrayList<>();
        ratings.add(3);
        ratings.add(2);
        ratings.add(1);
        ratings.add(3);

        long answer = countDecreasingRatings(ratings);
        System.out.println(answer);

    }

    private static long countDecreasingRatings(List<Integer> ratings) {

        long count = 0;

        int k = 2;

        while (k <= ratings.size()) {
            for (int i = 0; i < k - 1; i++) {
                boolean isDecreasing = true;
                for (int j = i; j < k - 1; j++) {
                    if (ratings.get(j) <= ratings.get(j + 1)) {
                        isDecreasing = false;
                    }
                }
                if (isDecreasing) {
                    count ++;
                }
            }
            k++;
        }

        boolean isDecreasing = true;
        for (int i = 0; i < ratings.size() - 1; i++ ) {
            if (ratings.get(i) <= ratings.get(i + 1)) {
                isDecreasing = false;
                break;
            }
        }

        if (isDecreasing) {
            count++;
        }

        return count;

    }
}
