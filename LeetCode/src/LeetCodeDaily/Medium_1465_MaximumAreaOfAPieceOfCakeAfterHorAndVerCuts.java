package LeetCodeDaily;

import java.util.Arrays;

public class Medium_1465_MaximumAreaOfAPieceOfCakeAfterHorAndVerCuts {
    public static void main(String[] args) {
//        int h = 5;
//        int w = 4;
//        int[] horizontalCuts = {1,2,4};
//        int[] verticalCuts = {1,3};
//        int h = 1000000000;
//        int w = 1000000000;
//        int[] horizontalCuts = {2};
//        int[] verticalCuts = {2};
        int h = 1000000000;
        int w = 1000000000;
        int[] horizontalCuts = {1,999999999};
        int[] verticalCuts = {1,999999999};
        int answer = maxArea(h, w, horizontalCuts,verticalCuts);
        System.out.println(answer);
    }

    private static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        //idea
        //We will make two new arrays (add the boundaries of the grid to the current arrays)
        //We can iterate through each array to find the maximum length between cuts in each array
        //Don't forget to include the boundaries
        //return the maximum area

        // Max Difference between any two horizontal cuts * Max Difference between any two vertical cuts will give the answer
        Arrays.sort(horizontalCuts); // to get consecutive cuts
        Arrays.sort(verticalCuts);
        long mod = (long)1e9+7;
        long a = 0,b = 0; // a = max diff of horizontal cuts b = max diff of vertical cuts
        int prev =0; // two edges of cake (0 - first cut)
        a = Math.max(a,h-horizontalCuts[horizontalCuts.length-1]); // and (edge - last cut) of the cake
        b = Math.max(b,w-verticalCuts[verticalCuts.length-1]);
        for(int i:horizontalCuts){
            a = Math.max(a,i-prev);
            prev = i;
        }
        prev = 0;
        for(int i:verticalCuts){
            b = Math.max(b,i-prev);
            prev = i;
        }
        return (int)((a*b)%mod);
    }
}
