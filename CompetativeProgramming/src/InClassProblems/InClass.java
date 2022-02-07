package InClassProblems;

import java.util.Collections;
import java.util.PriorityQueue;

public class InClass {

    public static void main (String[] args){

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(1);
        pq.add(2);
        pq.add(4);
        pq.add(3);
        pq.add(0);
        pq.add(2);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        System.out.println(pq);
        System.out.println("test");

        PriorityQueue<Pair> pq1 = new PriorityQueue<>();
        Pair p1 = new Pair('a',1);
        Pair p2 = new Pair('b',2);
        Pair p3 = new Pair('c',3);
        Pair p4 = new Pair('d',4);



    }

}
