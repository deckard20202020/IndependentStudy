package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class DP_Medium_139_WordBreak {
    public static void main(String[] args)  {

//        String s = "leetcode";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");

        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");

        boolean answer = wordBreak(s, wordDict);
        System.out.println(answer);
    }

    //This was my original solution.
    //It works, but it is only faster than 5% of the online submissions.
    //I need to find a faster solution
    private static boolean wordBreak(String s, List<String> wordDict) {
        boolean answer = false;

        String toCheck = "";
        boolean[] dp = new boolean[s.length()];
        int pointer = 0;

        //why is this a dp problem?
        for(int i = 0; i < s.length(); i++) {
            toCheck = toCheck + s.charAt(i);
            for (int j = 0; j <=i; j++) {
                if(wordDict.contains(toCheck) ||
                        (dp[j]==true && wordDict.contains(s.substring(j+1,i+1)))) {
                    dp[i] = true;

                }
            }

        }
        if(dp[dp.length-1] == true) {
            return true;
        }
        return answer;
    }
}
