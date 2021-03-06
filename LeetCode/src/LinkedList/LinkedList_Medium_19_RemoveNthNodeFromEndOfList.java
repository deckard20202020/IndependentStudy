package LinkedList;

import LinkedList.ListNode;

public class LinkedList_Medium_19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //idea: reverse the linked list and then go n nodes and remove it.
        // then reverse the list again.
        //this would take O(n)

        //Can we do this in one pass?
        //idea, have two pointers the slow one only updates after the first one iterates n times
        //if we hit null on the fast one, the slow one should be on the node that we need to remove

        //check edge cases
        if (n == 0) {
            return head;
        }
        if (head.next == null && n == 1) {
            return null;
        }
        if(head.next.next == null && n == 1) {
            head.next = null;
            return head;
        }
        if (head.next.next == null && n == 2) {
            head =  head.next;
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        //move the fast pointer by n nodes
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //check to see if we have reached the end and need to remove the first node
        if (fast == null) {
            head = head.next;
            return head;
        }

        //check to see if we have reached the end
        if (fast.next == null) {
            for (int i = 0; i < n-1; i++) {
                ListNode temp = slow.next.next;
                slow.next = temp;

                return head;
            }
        }


        //move both nodes until the fast one reaches the end
        while (fast.next != null) {
            //advance the fast pointer
            fast = fast.next;
            //advance the slow pointer
            slow = slow.next;
        }

        //now the slow pointer is pointing to the node that needs to be removed
        //remove the node
        ListNode temp = slow.next.next;
        slow.next = temp;

        return head;

    }
}
