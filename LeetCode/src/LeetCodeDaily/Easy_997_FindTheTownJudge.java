package LeetCodeDaily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Easy_997_FindTheTownJudge {
    public static void main(String[] args) {
        
//        int n = 2;
//        int[][] trust = {{1,2}};
//        int expect = 2;

//        int answer = findJudge(n, trust);
//        System.out.println(answer);
//        System.out.println("Expected: " + expect);

//        int n = 4;
//        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};

        int n = 4;
        int[][] trust2 = {{1,3},{1,4},{2,3}};
        int expect = -1;

        int answer = findJudge(n, trust2);
        System.out.println(answer);
        System.out.println("Expected: " + expect);

//        int n = 2;
//        int[][] trust = {};

    }

    private static int findJudge(int n, int[][] trust) {

        //first maps each number on the left to how many people they trust
        //second maps each member on the right to how many people trust them
        Map<Integer, Integer> numPeopleITrust = new HashMap();
        Map<Integer, Integer> numPeopleTrustMe = new HashMap();

        for(int i=0; i<trust.length;i++){
            numPeopleITrust.put(trust[i][0], numPeopleITrust.getOrDefault(trust[i][0], 0) +1 );
            numPeopleTrustMe.put(trust[i][1], numPeopleTrustMe.getOrDefault(trust[i][1], 0) +1 );
        }

        for(int i=1; i<=n; i++){

            //if a person trusts nobody
            if(numPeopleITrust.getOrDefault(i,0) == 0 &&
                    //and everyone else trusts them
                    numPeopleTrustMe.getOrDefault(i,0) == n-1){
                //then they are the judge
                return i;
            }
        }
        return -1;

//         //Faster but stolen off internet
//         //Why is this faster?
//         int[] t = new int[n+1];
//         boolean[] v = new boolean[n+1];

//         for(int[] arr : trust){
//             v[arr[0]]=true;
//             t[arr[1]]++;
//         }

//         for(int i=1;i<n+1;i++){
//             if(t[i]==n-1){
//                 if(!v[i]) return i;
//             }
//         }

//         return -1;
    }
}
