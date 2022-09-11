package Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Character.isDigit;

public class orders {
    public static void main(String[] args) {
        String[] orderList = {"zls 93 12", "fp kindle book", "10a echo show", "17g 12 25 6", "ab1 kindle book", "125 echo dot second generation"};
        String[] answer = findOrderList(orderList);
        for (String s : answer) {
            System.out.println(s);
        }

    }

    private static String[] findOrderList(String[] orderList) {

        List<String> list = new ArrayList<>();
        PriorityQueue<PrimeOrder> primeList = new PriorityQueue<>();

        for (String s : orderList) {
            if (!isDigit(s.charAt(s.length() - 1))) {
                String[] order = s.split("\\s++");
                String s1 = order[0];
                String data = "";
                for (int i = 1; i < order.length; i++) {
                    data = data + order[i] + " ";
                }
                PrimeOrder p = new PrimeOrder(s1, data);
                primeList.add(p);

            }
        }

        while (!primeList.isEmpty()) {
            String order = "";
            PrimeOrder p = primeList.remove();
            order = order + p.i + " ";
            order = order + p.metaData;
            list.add(order);
        }

        for (String s : orderList) {
            if (isDigit(s.charAt(s.length() - 1))) {
                list.add(s);
            }
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    static class PrimeOrder implements Comparable<PrimeOrder>{
        String i;
        String metaData;

        PrimeOrder (String i, String metaData) {
            this.i = i;
            this.metaData = metaData;
        }

        @Override
        public int compareTo(PrimeOrder o) {
            if (this.metaData.compareTo(o.metaData) > 0) {
                return 1;
            } else if (this.metaData.compareTo(o.metaData) < 0) {
                return -1;
            } else if (this.i.compareTo(o.i) > 0) {
                return 1;
            }
            return -1;
        }
    }
}
