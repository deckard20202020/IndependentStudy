package Block;

import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        String number = "1111122222";
        int k = 3;
        String answer = reduceTheNumber(number, k);
        System.out.print(answer);
    }

    private static String reduceTheNumber(String number, int k) {
        String answer = "";

        while (number.length() > k) {
            List<List<Integer>> groups = getGroups(number, k);
            number = concatenateGroups(groups);
            int a = 0;
        }

        return answer;
    }

    private static String concatenateGroups(List<List<Integer>> groups) {
        String number = "";

        for (List<Integer> group : groups) {
            for (Integer n : group) {
                char c = 'n';
            }
        }

        return number;
    }

    private static List<List<Integer>> getGroups(String number, int k) {
        List<List<Integer>> groups = new ArrayList<>();

        //first part of the list
        for (int i = 0; i < number.length(); i = i + k) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0 + i; j < k + i && j < number.length();  j++) {
                char c = number.charAt(j);
                int n = Character.getNumericValue(c);
                list.add(n);
            }
            groups.add(list);
        }

        //last part of list
//        int remainder = number.length() % k;
//        if (k > 0) {
//            List<Integer> list = new ArrayList<>();
//            for (int i = number.length() - 1; i > remainder; i++) {
//                char c = number.charAt(i);
//                int n = Character.getNumericValue(c);
//                list.add(list.size(), n);
//            }
//            groups.add(list);
//        }

        return groups;
    }
}
