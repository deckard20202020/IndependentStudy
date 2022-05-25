package SlidingWindow;

import java.util.HashMap;

public class SlidingWindow_Hard_76_MinimumWindowSubstring {
    public static void main (String[] args) {

//        String s = "ADOBECODEBANC";
//        String t = "ABC";

        String s = "a";
        String t = "b";

        String answer = minWindow(s,t);
        System.out.println((answer));
    }

    private static String minWindow(String s, String t) {
        //base case
        if (t.length() > s.length()) {
            return "";
        }

        //put the string we are searching for in a hashmap
        HashMap<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (target.keySet().contains(t.charAt(i))) {
                int n = target.get(t.charAt(i));
                n++;
                target.put(t.charAt(i), n);
            } else {
                target.put(t.charAt(i), 1);
            }
        }

        //initialize a HashMap for the window
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int ansStart = 0;
        int ansEnd = Integer.MAX_VALUE;
        boolean formed = false;

        while (right < s.length()) {
            //add the char on the right to our window map
            char c = s.charAt(right);
            if (window.keySet().contains(s.charAt(right))) {
                int n = window.get(s.charAt(right));
                n++;
                window.put(s.charAt(right), n);
            } else {
                window.put(s.charAt(right), 1);
            }

            //check to see if our window contains all the values in our target
            formed = areMapsGood(window, target);

            //if not, move the right pointer to the right
            if (!formed) {
                right++;
            } else {
                //if so, save our best values
                ansStart = Math.max(ansStart, left);
                ansEnd = Math.min(ansEnd, right);
                //and try to contract the window
                while (left <= right && formed) {
                    //remove the character from the window
                    c = s.charAt(left);
                    int num = window.get(c);
                    num--;
                    window.put(s.charAt(left), num);

                    //check to see if our window still contains all the values in our target
                    formed = areMapsGood(window, target);
                    //if we are still good, move the left and update our answer
                    if (formed) {
                        left++;
                        ansEnd = right;
                        ansStart = Math.max(ansStart, left);
                    } else {
                        //otherwise put the char back in our map
//                        num = window.get(c);
//                        num++;
//                        window.put(c, num);
                        //and break out of the while loop
                        //move the window to the right
                        left++;
                        right++;
                        break;
                    }
                }

            }

            //move the right pointer
//            right++;
        }

        //now we have the left and right index
        String answer = "";

        //check to see if we have updated the end
        if (ansEnd == Integer.MAX_VALUE) {
            return "";
        }

        for (int i = ansStart; i <= ansEnd; i++) {
            answer = answer + s.charAt(i);
        }

        return answer;
    }

    private static boolean areMapsGood(HashMap<Character, Integer> window, HashMap<Character, Integer> target) {

        for (Character c : target.keySet()) {
            if (!window.containsKey(c)) {
                return false;
            }
            if (target.get(c) > window.get(c)) {
                return false;
            }
        }

        return true;
    }

}
