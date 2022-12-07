package Paypal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WholeMinuteDilemma {
    public static void main(String[] args) {

        int[] songs = {40, 20, 60};
        int answer = playlist(songs);
        System.out.println(answer);
    }

    private static int playlist(int[] songs) {

        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        for (int num : songs) {

            int mod = num % 60;

            if (mod == 0) {
                answer += map.getOrDefault(0, 0);
            } else {
                answer += map.getOrDefault(60 - mod, 0);
            }

            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return answer;
//
//        int answer = 0;
//
//        //create our hashmap
//        HashMap<Integer, Integer> map = new HashMap();
//        for (int n : songs) {
//            int mod = n % 60;
//            if (map.containsKey(mod)) {
//                int quant = map.get(mod);
//                quant++;
//                map.put(mod, quant);
//            } else {
//                map.put(mod, 1);
//            }
//        }
//
//        //scroll through the array and see if there is a match for our target
//        for (int i = 0; i < songs.length; i++) {
//            int first = songs[i] % 60;
//            int target = 60 - first;
//            if (map.containsKey(target)) {
//                answer += map.get(target);
//            }
//        }
//
//    return  1;

    }
}
