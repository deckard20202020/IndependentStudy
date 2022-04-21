package LinkedList;

import LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LinkedList_Hard_23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        //idea-put all  nodes in PQ and just pop them
        //There is another way to do this in same amount of time but with less space
        //Merge with Divide and Conquer
        //See solution on Leetcode

        //edge cases
        if (lists == null) {
            return null;
        }
        if (lists.length == 1 && lists[0] == null) {
            return null;
        }

        //define PriorityQueue with comparator-KNOW THIS!!!
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
