package DynamicProgramming;

import java.util.ArrayList;

public class Testing {
    public static void main (String[] args) {

        int rowIndex = 4;

        ArrayList<Integer> answer = getRow(rowIndex);
        System.out.println(answer);
    }

    private static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (rowIndex < 0)
            return result;

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }

}
