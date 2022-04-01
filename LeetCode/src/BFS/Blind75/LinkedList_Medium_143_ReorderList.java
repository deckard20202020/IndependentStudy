package BFS.Blind75;

public class LinkedList_Medium_143_ReorderList {
    public void reorderList(ListNode head) {

        //idea 1 could scroll through the list making a pair for each node.
        //pairs include value and index
        //make 2 pq's
        //put every other pair in corresponding pq
        //if index is even put in one pq
        //if index is odd put on other pq
        //make new list until both pq's are empty

        //idea 2 go to the center of the list
        //separate the lists
        //reverse the second half of the list
        //merge the two lists
        //return the new list

        //edge case
        if (head == null || head.next == null) {
            return;
        }

        //find middle of list
        //This will be the head of the first half of the list
        ListNode l = head;
        //this will be the tail of the first half of the list
        ListNode prev = null;
        //this will be the end of the second half of the list
        ListNode fast = head;
        //this will be the head of the second half of the list
        ListNode slow = head;


        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        //split the list into 2
        prev.next = null;

        //reverse the last part of the list
        ListNode reversed = reverseList(slow);

        //merge the two lists
        mergeLists(l, reversed);

        // head = answer;
        return;

    }

    public void mergeLists(ListNode first, ListNode second) {
        while (first != null) {
            //give reference to first.next and second.next
            ListNode first_next = first.next;
            ListNode second_next = second.next;

            //assign next node-will be the node in the second list
            first.next = second;

            //check to see if we are done
            if (first_next == null) {
                break;
            }

            //assign next node-will be the next node in the first list
            second.next = first_next;

            //advance down both lists
            first = first_next;
            second = second_next;
        }
    }


    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            //store the next node
            next = current.next;
            //make the switch
            current.next = prev;
            //advance
            prev = current;
            current = next;
        }

        //reassign the head
        head = prev;

        return head;
    }
}
