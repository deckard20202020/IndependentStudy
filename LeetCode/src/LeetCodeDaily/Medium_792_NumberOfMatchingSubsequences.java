package LeetCodeDaily;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Medium_792_NumberOfMatchingSubsequences {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};
        int answer = numMatchingSubseq(s, words);
        System.out.println(answer);
    }

    private static int numMatchingSubseq(String s, String[] words) {

        //idea 1.
        //two pointer problem
        //This seems to work but time limit is exceeded
        //Need to come up with a better way

        int count = 0;

        for(String word : words) {
            int wordPointer = 0;
            int sPointer = 0;

            while (wordPointer < word.length() && sPointer < s.length()) {

                char wordChar = word.charAt(wordPointer);
                char sChar = s.charAt(sPointer);

                //if we have a success
                if (wordChar == sChar && wordPointer == word.length() - 1) {
                    count = count + 1;
                    break;
                }

                //if there is no match
                if (wordChar != sChar) {
                    //move along the s
                    sPointer ++;
                }

                //if there is a match
                if (wordChar == sChar) {
                    //move both pointers along
                    wordPointer++;
                    sPointer++;
                }
            }
        }

        return count;


    }
}
