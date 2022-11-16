package LeetCodeDaily;

import java.util.ArrayList;
import java.util.List;

public class Medium_443_StringCompression {
    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int answer = compress(chars);
        System.out.println(answer);
    }

    private static int compress(char[] chars) {

        int answer = 0;

        //chars has at least one element
        //base case
        if (chars.length == 1) {
            return 1;
        }

        List<Character> list = new ArrayList<>();

        int nextIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            char first = chars[i];
            int j = i + 1;
            char count = '1';
            while (j < chars.length && first == chars[j]) {

                    j++;
                    count ++;

            }
            if (count == 1) {
                list.add(first);
            } else {
                list.add(first);
                list.add(count);
            }
            i = j - 1;
        }

//        chars = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            char c = (list.get(i));

            chars[i] = c;
        }
        return list.size();
    }
}
