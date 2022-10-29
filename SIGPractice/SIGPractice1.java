package SIGPractice;

import java.util.ArrayList;
import java.util.HashMap;

public class SIGPractice1 {
    public static void main(String[] args) {

        ArrayList<String> queryType = new ArrayList<>();
        queryType.add("Add");
        queryType.add("Add");
        queryType.add("Add");
        queryType.add("Add");
//        queryType.add("AddToKey");
        queryType.add("AddToValue");
        queryType.add("AddToKey");
        queryType.add("get");
        queryType.add("get");
        ArrayList<Integer> query = new ArrayList<>();
        query.add(1);
        query.add(1);
        query.add(2);
        query.add(2);
        query.add(3);
        query.add(3);
        query.add(4);
        query.add(4);

        //add to value
        query.add(1);

        //add to key
        query.add(1);

        query.add(2);
        query.add(3);

        double answer = solve(queryType, query);
        System.out.println(answer);

    }

    private static double solve(ArrayList<String> queryType, ArrayList<Integer> query) {

        double answer = 0;
        int listOffset = 0;
        double valueOffset = 0;
        int keyOffset = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < queryType.size(); i++) {
            String q = queryType.get(i);

            if (q.equals("Add")) {
                if (map.containsKey(query.get(i + listOffset + keyOffset))) {
                    int key = query.get(i + listOffset + keyOffset);
                    int n = map.get(key);
                    n = n + query.get(i + 1 + listOffset);
                    map.put(key, n);
                } else {
                    int key = query.get(i + listOffset + keyOffset);
                    int n = query.get(i + 1 + listOffset);
                    map.put(key, n);
                }

                listOffset++;
            }
            if (q.equals("AddToKey")) {
                keyOffset = keyOffset + query.get(i + listOffset);
            }
            if (q.equals("AddToValue")) {
                valueOffset = valueOffset + query.get(i + listOffset);
            }
            if (q.equals("get")) {
                int key = query.get(i + listOffset);
                key = key - keyOffset;
                double a = map.get(key);
                a = a + valueOffset;
                answer = answer + a;
            }
        }

        return answer;
    }
}
