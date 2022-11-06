package DoorDash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MergingPalindromes {

    //THIS IS WRONG
    //NEED TO FIND THE LONGEST PALINDROME IN EACH WORD, THEN MERGE THE TWO
    //I DID IT IN THE WRONG ORDER

    public static void main(String args[]) {
//        String s1 = "aabbc";
//        String s2 = "ddefefq";
//        String s1 = "aab";
//        String s2 = "cca";
//        String s1 = "adaab";
//        String s2 = "cac";
//        String s1 = "aaaabbbccc";
//        String s2 = "ddeeccc";
        String s1 = "adaab";
        String s2 = "cac";

        String answer = mergePalindromes(s1, s2);
        System.out.println(answer);
    }

    private static String mergePalindromes(String s1, String s2) {

        String string1 = findLongestPalindrome(s1);
        String string2 = findLongestPalindrome(s2);
        String answer = helper(string1, string2);
        return answer;
    }

    private static String helper(String s1, String s2) {

        //only dealing with lowercase letters
        String answer = "";

        int maxLength = Math.max(s1.length(), s2.length());

        //O(n)
        //put all the letters into a hashmap
        HashMap<Character, Integer> lettersInWords = new HashMap<>();
        for (int i = 0; i < maxLength; i++) {

            //if we are less than the length of s1
            if (i < s1.length()) {
                if (lettersInWords.keySet().contains(s1.charAt(i))) {
                    int n = lettersInWords.get(s1.charAt(i));
                    n++;
                    lettersInWords.put(s1.charAt(i), n);
                } else {
                    lettersInWords.put(s1.charAt(i), 1);
                }
            }

            //if we are less than the length of s2
            if (i < s2.length()) {
                if (lettersInWords.keySet().contains(s2.charAt(i))) {
                    int n = lettersInWords.get(s2.charAt(i));
                    n++;
                    lettersInWords.put(s2.charAt(i), n);
                } else {
                    lettersInWords.put(s2.charAt(i), 1);
                }
            }
        }

        List<Character> listEven = new ArrayList<>();
        int odd = 0;
        Character oddChar = null;
        boolean hasOddChar = false;

        //O(n)
        //find all the letters with even count and put them in a list
        //also find the character with the highest odd number
        for (Character c : lettersInWords.keySet()) {
            if (lettersInWords.get(c) % 2 == 0) {
                listEven.add(c);
            } else {
                //it has odd value
                if (lettersInWords.get(c) >= odd) {
                    hasOddChar = true;
                    odd = lettersInWords.get(c);
                    if (oddChar != null && lettersInWords.get(c) < oddChar) {
                        oddChar = c;
                    } else {
                        oddChar = c;
                    }

                }
            }
        }

        //O(1)
        //add the odd character to the list if it has more than one
        if (odd > 1) {
            int newHMValue = odd - 1;
            lettersInWords.put(oddChar, newHMValue);
            listEven.add(oddChar);
        }

        //O(nlogn)
        //sort this list alphabetically
        Collections.sort(listEven);

        //O(1)
        //we need to add the odd char(s) in the middle
        if (hasOddChar) {
                answer = answer.concat(oddChar.toString());
        }

        //O(n)
        //add the even chars but do it in reverse order
        for (int j = listEven.size() - 1; j >=0; j--) {
            Character c = listEven.get(j);
            int count = lettersInWords.get(c) / 2;
            for (int i = 0; i < count; i++) {
                String s = c.toString();
                answer = s + answer + s;
            }
        }

        return answer;
    }

    public static String findLongestPalindrome(String s) {


        //only dealing with lowercase letters
        String answer = "";

        int maxLength = s.length();

        //O(n)
        //put all the letters into a hashmap
        HashMap<Character, Integer> lettersInWords = new HashMap<>();
        for (int i = 0; i < maxLength; i++) {

            //if we are less than the length of s1
            if (i < s.length()) {
                if (lettersInWords.keySet().contains(s.charAt(i))) {
                    int n = lettersInWords.get(s.charAt(i));
                    n++;
                    lettersInWords.put(s.charAt(i), n);
                } else {
                    lettersInWords.put(s.charAt(i), 1);
                }
            }
        }

        List<Character> listEven = new ArrayList<>();
        List<Character> listOdd = new ArrayList<>();
        int odd = 0;
        Character oddChar = null;
        boolean hasOddChar = false;

        //O(n)
        //find all the letters with even count and put them in a list
        //also find the character with the highest odd number
        for (Character c : lettersInWords.keySet()) {
            if (lettersInWords.get(c) % 2 == 0) {
                listEven.add(c);
            } else {
                //it has odd value
                hasOddChar = true;
                listOdd.add(c);
            }
        }

        //find the odd character that we will use
        //we will want the one at the end
        Collections.sort(listOdd);
        Character oddToUse = listOdd.get(listOdd.size() - 1);

        //update the hashmap values of the other odd characters
        for (int i = 0; i < listOdd.size() - 1; i++) {
            Character c = listOdd.get(i);
            int v = lettersInWords.get(c);
            v--;
            lettersInWords.put(c, v);
            listEven.add(c);
        }

        odd = lettersInWords.get(oddToUse);


        //O(1)
        //add the odd character to the list if it has more than one
        if (odd > 1) {
            int newHMValue = odd - 1;
            lettersInWords.put(oddChar, newHMValue);
            listEven.add(oddToUse);
        }

        //O(nlogn)
        //sort this list alphabetically
        Collections.sort(listEven);

        //O(1)
        //we need to add the odd char(s) in the middle
        if (hasOddChar) {
            answer = answer.concat(oddToUse.toString());
        }

        //O(n)
        //add the even chars but do it in reverse order
        for (int j = listEven.size() - 1; j >=0; j--) {
            Character c = listEven.get(j);
            int count = lettersInWords.get(c) / 2;
            for (int i = 0; i < count; i++) {
                String t = c.toString();
                answer = t + answer + t;
            }
        }

        return answer;

    }
}
