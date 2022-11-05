package IBM;

import java.util.HashMap;

public class EfficientTeams {
    public static void main(String[] args) {

        int[] skill = {1,2,3,2};
//        int[] skill = {5, 4, 2, 1};
//        int[] skill = {1,1,1,2};
        int answer = getTotalEfficiency(skill);
        System.out.println(answer);
    }

    private static int getTotalEfficiency(int[] skill) {
         int answer = 0;

         //n is even
        //find the target for each pair
        int sumOfArr = 0;
        //and build a hashmap of values and num of occurances
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < skill.length; i++) {
            sumOfArr += skill[i];
            if (map.containsKey(skill[i])) {
                int value = map.get(skill[i]);
                value++;
                map.put(skill[i], value);
            } else {
                map.put(skill[i], 1);
            }
        }
        int target = sumOfArr / 2;

        //scroll through keys of the array and see if we can hit the target
        for (int i = 0; i < skill.length; i++) {

            //if the number is still in the map
            if (map.containsKey(skill[i])) {
                int numToSolve = skill[i];
                //update the map
                int value = map.get(numToSolve);
                if (value == 1) {
                    map.remove(numToSolve);
                } else {
                    value--;
                    map.put(numToSolve, value);
                }
                //find our pair
                int lookingFor = target - numToSolve;
                //check the map again
                if (map.containsKey(lookingFor)) {
                    int v = map.get(lookingFor);
                    if (v == 1) {
                        map.remove(lookingFor);
                    } else {
                        v--;
                        map.put(lookingFor, v);
                    }
                    //update our answer
                    answer = answer + (numToSolve * lookingFor);
                } else {
                    //we can't pair them up
                    return -1;
                }


            }
        }


         return answer;
    }
}
