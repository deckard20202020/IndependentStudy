package DynamicProgramming;

public class DP_Easy_1025_DivisorGame {
    public boolean divisorGame(int n) {
        //I didn't use DP on this at all
        //original idea = O(n)

//         //we basically want to find the number of divisors between 1 and n
//         //if the number of divisors
//         ArrayList<Integer> divisors = new ArrayList<Integer>();
//         for (int i = 1; i < n; i++) {
//             if (n%1 == 0) {
//                 divisors.add(i);
//             }
//         }

//         if (divisors.size()%2 == 0) {
//             return false;
//         } else {
//             return true;
//         }

        //faster with math
        //O(1)
        return n%2 == 0;
    }
}
