package ATT;

import java.util.ArrayList;
import java.util.List;

public class ATT3 {
    public static void main(String[] args) {
        List<String> loggedMoves = new ArrayList<>();
        loggedMoves.add("x/");
        loggedMoves.add("y/");
        loggedMoves.add("../");
        loggedMoves.add("z/");
        loggedMoves.add("./");
        int answer = minimumSteps(loggedMoves);
        System.out.println(answer);
    }

    private static int minimumSteps(List<String> loggedMoves) {
        int numDeep = 0;
        for (int i = 0; i < loggedMoves.size(); i++) {
            String curr = loggedMoves.get(i);


        }

        return 1;
    }
}
