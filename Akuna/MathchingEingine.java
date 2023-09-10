package Akuna;

import java.util.*;

public class MathchingEingine {
    public static void main(String[] args) {

    }

    class Orders {

        public Orders() {

        }

        public void newOrder(boolean is_buy, int price, int quantity, String id) {

            if (is_buy) {
                //look in the sell
            }
            //print out "INSERT {B
        }

        public void cancel(String id) {

        }

        public void modify(String id, boolean is_buy, int price, int quantity) {

        }
    }

//    class Orders {
//        private Map<Integer, List<Integer>> orders;
//        private PriorityQueue<int[]> buys;
//        private PriorityQueue<int[]> sells;
//
//        public Orders() {
//            orders = new HashMap<>();
//            buys = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
//            sells = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
//        }
//
//        public void newOrder(boolean isBuy, int price, int quantity, int id) {
//            PriorityQueue<int[]> pull = isBuy ? sells : buys;
//            PriorityQueue<int[]> push = isBuy ? buys : sells;
//            Comparator<Integer> compare = isBuy ? Integer::compare : (a, b) -> Integer.compare(b, a);
//            int neg = isBuy ? 1 : -1;
//
//            while (quantity > 0 && !pull.isEmpty() && compare.compare(Math.abs(pull.peek()[0]), price) <= 0) {
//                int oldPrice = Math.abs(pull.peek()[0]);
//                int[] oldOrder = pull.poll();
//                int oldQuantity = oldOrder[1];
//                int oldId = oldOrder[2];
//
//                if (!orders.containsKey(oldId) || !Arrays.equals(orders.get(oldId).toArray(), new Integer[]{oldPrice, oldQuantity, !isBuy})) {
//                    continue;
//                }
//
//                int take = Math.min(oldQuantity, quantity);
//                System.out.printf("TRADE %d %d %d %d%n", id, oldId, oldPrice, take);
//                oldQuantity -= take;
//
//                if (oldQuantity == 0) {
//                    orders.remove(oldId);
//                } else {
//                    push.offer(new int[]{neg * oldPrice, oldQuantity, oldId});
//                }
//
//                quantity -= take;
//            }
//
//            if (quantity > 0) {
//                String op = isBuy ? "BUY" : "SELL";
//                int invNeg = isBuy ? -1 : 1;
//                System.out.printf("INSERT %s %d %d %d%n", op, id, price, quantity);
//
//                List<Integer> orderInfo = new ArrayList<>();
//                orderInfo.add(price);
//                orderInfo.add(quantity);
//                orderInfo.add(isBuy ? 1 : 0);
//
//                orders.put(id, orderInfo);
//                push.offer(new int[]{invNeg * price, quantity, id});
//            }
//        }
//
//        public void cancel(int id) {
//            List<Integer> orderInfo = orders.get(id);
//            int quantity = orderInfo.get(1);
//            orders.remove(id);
//            System.out.printf("CANCEL %d %d%n", id, quantity);
//        }
//
//        public void modify(boolean isBuy, int price, int quantity, int id) {
//            if (orders.containsKey(id)) {
//                cancel(id);
//                newOrder(isBuy, price, quantity, id);
//            }
//        }
//    }
}
