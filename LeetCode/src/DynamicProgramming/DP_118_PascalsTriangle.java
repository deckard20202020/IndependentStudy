package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class DP_118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        //base cases
        if (numRows == 1) {
            list2.add(1);
            list1.add(list2);
            return list1;
        }

        if (numRows == 2) {
            list2.add(1);
            list1.add(list2);
            list3.add(1);
            list3.add(1);
            list1.add(list3);

            return list1;
        }


        list2.add(1);
        list1.add(list2);

        list3.add(1);
        list3.add(1);
        list1.add(list3);

        for (int i = 3; i <=numRows; i++) {
            list3 = addARow(list3, i);
            list1.add(list3);
        }

        return list1;
    }

    private static List<Integer> addARow(List<Integer> l, int i) {
        List<Integer> answerList = new ArrayList<Integer>();

        answerList.add(0, l.get(0));

        for (int j = 1; j < i-1; j++) {
            answerList.add(j, l.get(j-1) + l.get(j));
        }
        answerList.add(i-1, l.get(i-2));

        return answerList;
    }
}
