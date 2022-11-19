package ZipRecruiter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StorePurchases {
    public static void main(String[] args) {
        String[][] logs = {{"supply", "item 1", "3", "50"},
                {"sell", "item 1" , "1", "100"},
                {"supply", "item 2", "2", "30"},
                {"return", "item 2", "1", "40"},
                {"sell", "item 2", "2", "50"}};

        String[] answer = storePurchases(logs);
        for (String s : answer) {
            System.out.print(s + ", ");
        }
    }

    private static String[] storePurchases(String[][] logs) {

        List<String> list = new ArrayList<>();

        //this is my inventory
        HashMap<String, List<Integer>> map = new HashMap<>();

        for (String[] arr : logs) {
            String op = arr[0];
            String item = arr[1];
            int quant = Integer.valueOf(arr[2]);
            int price = Integer.valueOf((arr[3]));

            switch (op) {
                case "sell":
                    int profit = 0;
                    for (int i = 0; i < quant; i++) {
                        List<Integer> inventory = map.get(item);
                        int cost = inventory.get(0);
                        profit += price - cost;
                        //remove this from the list
                        inventory.remove(0);
                    }
                    String entry = Integer.toString(profit);
                    list.add(entry);
                    break;

                case "supply":
                    if (map.containsKey(item)) {
                        List<Integer> l = map.get(item);
                        for (int i = 0; i < quant; i++) {
                            l.add(price);
                        }
                        map.put(item, l);
                    } else {
                        List<Integer> l = new ArrayList<>();
                        for (int i = 0; i < quant; i++) {
                            l.add(price);
                        }
                        map.put(item, l);
                    }
                    break;

                default:
                    //assume customers can't return unless we have sold
                    List<Integer> l = map.get(item);
                    for (int i = 0; i < quant; i++) {
                        //add to the front of the list if we HAVE to sell used first
                        l.add(0, price);
                    }
                    map.put(item, l);
            }
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
