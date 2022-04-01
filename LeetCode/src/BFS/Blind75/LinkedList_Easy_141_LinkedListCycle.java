package BFS.Blind75;

public class LinkedList_Easy_141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        //idea store the value and position of each node in a hashmap
        //every time we come across a node in the list we can see if it's in the hash map.
        //this might be nice if we come across a similar problem but are asked the position of the loop
        //spent a while on this- doesn't work
        //this only works if the linked list node values are distinct

        //second idea-use a fast pointer and a slow pointer.
        //if there is a loop eventually they will meet

        //initialize the two pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;

    }
}
