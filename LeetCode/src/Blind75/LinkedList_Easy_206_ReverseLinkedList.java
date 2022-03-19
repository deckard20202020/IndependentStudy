package Blind75;

public class LinkedList_Easy_206_ReverseLinkedList {

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
            //switch the pointer of current
            curr.next = prev;
            // advance the previous
            prev = curr;
            //advance the current
            curr = next;
        }
        //change the head
        //it's not current, current is now null, should be previous
        head = prev;

        return head;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
