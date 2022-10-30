package SIGPractice;

import java.util.ArrayList;
import java.util.HashMap;

public class SIGPractice3 {

    public static void main(String[] args) {
//
//        String[] queryType = {"insert", "addToValue", "get", "insert", "addToKey", "addToValue", "get"};
//        int[][] query = { {1,2}, {2}, {1}, {2,3}, {1}, {-1}, {3} };

        String[] queryType = {"addToKey", "addToKey", "insert", "addToValue", "addToValue", "get", "addToKey", "insert", "addToKey", "addToValue"};
        int[][] query = {{-3}, {-1}, {0, -3}, {3}, {-1}, {0}, {-1}, {-4,-5}, {-1}, {-4}};

        double answer = solve(queryType, query);
        System.out.println(answer);

    }

    private static double solve(String[] queryType, int[][] query) {

        double answer = 0;
        double valueOffset = 0;
        int keyOffset = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < queryType.length; i++) {
            String q = queryType[i];

            if (q.equals("insert")) {
//                if (map.containsKey(query[i + keyOffset])) {
                if (map.containsKey(query[i][0])) {
                    int key = query[i + keyOffset][0];
                    int n = map.get(key);
                    n = n + query[i][1];
                    map.put(key, n);
                } else {
//                    int key = query[i + keyOffset][0];
                    int key = query[i][0];
                    int n = query[i][1];
                    map.put(key, n);
                }
            }
            if (q.equals("addToKey")) {
                keyOffset = keyOffset + query[i][0];
            }
            if (q.equals("addToValue")) {
                valueOffset = valueOffset + query[i][0];
            }
            if (q.equals("get")) {
                int key = query[i][0];
                key = key;
                double a = map.get(key);
                a = a + valueOffset;
                answer = answer + a;
            }
        }

        return answer;
    }
}
