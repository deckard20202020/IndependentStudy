package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class DP_Easy_119_PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {

        ArrayList<Integer> answer = new ArrayList<Integer>();

        //add the first 1
        answer.add(1);

        //indexing becomes a little confusing but should work
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = answer.size() - 2; j >=0; j--) {
                answer.set(j+1, answer.get(j) + answer.get(j+1));
            }
            //add the last 1
            answer.add(1);

        }

        return answer;

    }
}
