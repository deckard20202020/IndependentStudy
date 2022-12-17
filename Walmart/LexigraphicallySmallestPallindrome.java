package Walmart;

public class LexigraphicallySmallestPallindrome {
    public static void main(String[] args) {

//        String string = "aabc";
        String string = "aabcd";
        String answer = palindrome(string);
        System.out.println(answer);

    }

//    static int N = 200100;
//    static int M = 26;
//    static char[] s = new char[N];
//    static int[] freq = new int[26];
//    static int[] odd = new int[26];

    public static String palindrome(String string) {

        int[] freq = new int[26];
        int[] odd = new int[26];

        String answer = "";

        int n = string.length();
        int odd_count = 0;
        int odd_mid = 0;
        for (int i = 0; i < n; ++i) {
//            ++freq[s[i] - 'a'];
            freq[Integer.valueOf(string.charAt(i) - 'a')]++;
        }
        for (int i = 0; i < 26; ++i) {
            if (freq[i] % 2 == 1) {
                odd[odd_count] = i;
                ++odd_count;
            }
        }
        for (int i = 0, j = odd_count - 1; i <= j; ++i, --j) {
            if (i != j) {
                ++freq[odd[i]];
                --freq[odd[j]];
                odd_count -= 2;
            } else {
                odd_mid = odd[i];
            }
        }
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < freq[i] / 2; ++j) {
                int letterInt = 'a' + i;
                char c = (char)letterInt;
                answer = answer + c;
            }
        }
        if (odd_count > 0) {
            int letterInt = 'a' + odd_mid;
            char c = (char)letterInt;
            answer = answer + c;
//            System.out.print('a' + odd_mid);
        }
        for (int i = 26 - 1; i >= 0; --i) {
            for (int j = 0; j < freq[i] / 2; ++j) {
                int letterInt = 'a' + i;
                char c = (char)letterInt;
                answer = answer + c;
//                System.out.print('a' + i);
            }
        }
//        System.out.print('\n');

        return answer;
    }

}
