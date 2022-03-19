package Blind75;

import java.util.HashMap;
import java.util.Map;

public class Testing {
    public static void main (String[] args) {

//        Input: head = [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode (2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode (5);
        ListNode answer = reverseList(head);
        System.out.println(answer.val);
    }

    private static ListNode reverseList(ListNode head) {

        //check edge cases
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        //iterate through the list
        while (curr != null) {
            //store the next node
            next = curr.next;
            //start reversing
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

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
