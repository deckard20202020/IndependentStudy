import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class main {

    public static void main (String args[]) {
        //int[] array = {4,5,6,7,0,1,2};
        //int[] array = {11,13,15,17};
        //[11,13,15,17]
        //[9,3,2,10]
        int[] array = {1,2,2,2,3,3,3};
        int k = 2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], i);
            } else {
                int increment = map.get(array[i]);
                increment ++;
                map.put(array[i], increment);
            }

        }

        System.out.print(map);




    }
}

