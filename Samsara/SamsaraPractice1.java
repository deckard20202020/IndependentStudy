package Samsara;

import java.util.HashMap;

public class SamsaraPractice1 {
    public static void main(String[] args) {
        int[][] lamps = {{-2,3}, {2,3}, {2,1}};
        int answer = findNum(lamps);
        System.out.println(answer);
    }

    private static int findNum(int[][] lamps) {
            int count = 0;

            //key is location, value is count
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int[] arr : lamps) {
                int location = arr[0];
                int range = arr[1];
                int left = location - range;
                int right = location + range;

                int start = left;
                while (start <= right) {

                    if (map.containsKey(start)) {
                        int n = map.get(start);
                        n++;
                        map.put(start, n);
                    } else {
                        map.put(start, 1);
                    }

                    start++;
                }
            }

            for (Integer key : map.keySet()) {
                if (map.get(key) == 1) {
                    count++;
                }
            }

            return count;
    }
}
