package PracticeExam_22_5_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProblemC {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\PracticeExam_22_5_1\\tests.txt");
        Scanner scanner = new Scanner((file));
//
//        Scanner scanner = new Scanner(System.in);
//
        String string = scanner.nextLine();
        String[] splitString = string.split("\\s+");

        int numberOfEmployees = Integer.parseInt(splitString[0]);
        int numberOfOrders = Integer.parseInt(splitString[1]);

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //andd the employees to the hashmap
        for (int i = 1; i <= numberOfEmployees; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int j = 2; j <= numberOfEmployees; j++) {
            string = scanner.nextLine();
            int manager = Integer.parseInt(string);
            List<Integer> managers = map.get(j);
            managers.add(manager);
            map.put(j, managers);
        }

        //now we have our graph
        for (int order = 0; order < numberOfOrders; order++) {
            string = scanner.nextLine();
            String[] s = string.split("\\s+");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);

            boolean answer = isPossible(from, to, map);
            if(answer) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }

    }

    private static boolean isPossible(int from, int to, HashMap<Integer, List<Integer>> map) {

        Stack<Integer> stack = new Stack<>();
        //we will do a bfs from "from" to "to"
        List<Integer> neighbors = map.get(from);
        for(Integer integer : neighbors) {
            stack.add(integer);
        }

        while (!stack.isEmpty()) {
            Integer n = stack.pop();
            if ( n == to) {
                return true;
            } else {
                neighbors = map.get(n);
                for(Integer integer : neighbors) {
                    stack.add(integer);
                }
            }
        }

        return false;
    }
}
