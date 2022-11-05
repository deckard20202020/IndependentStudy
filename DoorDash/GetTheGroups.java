package DoorDash;

import java.util.*;

public class GetTheGroups {
    public static void main(String[] args) {

        int n = 4;
        String[] queryType = {"Friend", "Friend", "Total"};
        int[] student1 = {1,2,1};
        int[] student2 = {2,3,4};

        getTheGroups(n, queryType, student1, student2);
    }

    private static void getTheGroups(int n, String[] queryType, int[] student1, int[] student2) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(i, list);
        }

        for (int i = 0; i < queryType.length; i++) {
            //make our graph bigger
            if (queryType[i].equals("Friend")) {
                List<Integer> list1 = map.get(student1[i]);
                list1.add(student2[i]);
                List<Integer> list2 = map.get(student2[i]);
                list2.add(student1[i]);
                map.put(student1[i], list1);
                map.put(student2[i], list2);
            }

            if (queryType[i].equals("Total")) {
                int a = dfs(map, student1[i]);
                int b = dfs(map, student2[i]);
                System.out.println(a + b);
            }
        }

    }

    private static int dfs(HashMap<Integer, List<Integer>> map, int i) {

        if (map.get(i).size() == 1) {
            return 1;
        }

        int answer = 0;
        Set<Integer>visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(i);

        while(!stack.isEmpty()) {
            int n = stack.pop();
            if (!visited.contains(n)) {
                visited.add(n);
                answer++;
                for (Integer m : map.get(n)) {
                    stack.add(m);
                }
            }
        }

        return answer;
    }
}
