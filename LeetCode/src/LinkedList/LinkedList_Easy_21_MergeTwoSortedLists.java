package LinkedList;

import Blind75.ListNode;

public class LinkedList_Easy_21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //idea 1 iterate through both lists and put them in a priority queue
        //remove them one by one and link them

        //idea 2 scroll through each list simultaneously
        //add them to a new list as you go
        //This should be O(n+m)

        //check edge cases
        //both null
        if ( list1 == null && list2 == null) {
            return null;
        }
        //list1 is null
        if (list1 == null) {
            return list2;
        }
        //list 2 is null
        if (list2 == null) {
            return list1;
        }

        //initialize our new list and pointers
        ListNode answer = new ListNode();
        ListNode first = new ListNode();
        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();

        if (list1.val < list2.val) {
            answer = list1;
            first = list1;
            p1 = list1.next;
            p2 = list2;
        } else {
            answer = list2;
            first = list2;
            p1 = list1;
            p2 = list2.next;
        }

        //scroll through the lists until one is empty
        while (p1 != null && p2 != null) {
            ListNode toAdd = new ListNode();
            if (p1.val < p2.val) {
                answer.next = p1;
                answer = answer.next;
                p1 = p1.next;
            } else {
                answer.next = p2;
                answer = answer.next;
                p2 = p2.next;
            }
        }

        //attach the next node of the list that isn't empty
        if (p1 == null) {
            answer.next = p2;
        } else {
            answer.next = p1;
        }

        return first;

    }
}
