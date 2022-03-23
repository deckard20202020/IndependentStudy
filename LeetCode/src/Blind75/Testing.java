package Blind75;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Testing {
    public static void main (String[] args) {

        ListNode[] list = new ListNode[3];
        ListNode head = new ListNode(1);
        head.next = new ListNode (4);
        head.next.next = new ListNode(5);
        list[0] = head;

        head = new ListNode(1);
        head.next = new ListNode (3);
        head.next.next = new ListNode(4);
        list[1] = head;

        head = new ListNode(2);
        head.next = new ListNode (6);
        list[2] = head;

        ListNode answer = mergeKLists(list);

        ListNode current = answer;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }



    }

    public static ListNode mergeKLists(ListNode[] lists) {

        //idea-put all  nodes in PQ and just pop them

        //edge cases
        if (lists == null) {
            return null;
        }
        if (lists.length == 1 && lists[0] == null) {
            return null;
        }

        //define PriorityQueue with comparator
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });


        for (int i =0; i < lists.length; i++){
            ListNode h = lists[i];
            while (h != null) {
                int val = h.val;
                ListNode n = new ListNode(val);
                pq.add(n);
                h = h.next;
            }
        }

        //empty the priority queue
        ListNode head = pq.poll();
        ListNode current = head;
        while (pq.size() > 0) {
            ListNode next = pq.poll();
            current.next = next;
            current = current.next;
        }

        return head;


    }




}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
