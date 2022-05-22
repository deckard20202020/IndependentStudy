package SlidingWindow;

public class SlidingWindow_Medium_567_PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean answer = checkInclusion(s1, s2);
        System.out.println(answer);
    }

    private static boolean checkInclusion(String s1, String s2) {

        //base case
        if(s1.length() > s2.length()) {
            return false;
        }
        //idea
        //put each substring into an array 26 long
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        //Need to learn this!!!!!!!!!!!!!!!!!!!!!
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        //check if matches
        for (int i = 0; i < s2.length() -s1.length(); i++) {
            if (matches(s1map, s2map)) {
                return true;
            }
            //update the maps for the window
            //we are moving the window over by 1
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }

        //check the last window
        return matches(s1map, s2map);
    }

    private static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i]) {
                return false;
            }
        }

        return true;
    }
}
