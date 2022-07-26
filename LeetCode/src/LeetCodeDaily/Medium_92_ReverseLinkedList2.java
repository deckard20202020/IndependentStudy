package LeetCodeDaily;

public class Medium_92_ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int left = 2;
        int right = 4;
        ListNode answer = reverseBetween(head, left, right);
        System.out.println(answer.val);
        System.out.println(answer.next.val);
        System.out.println(answer.next.next.val);
        System.out.println(answer.next.next.next.val);
        System.out.println(answer.next.next.next.next.val);
    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {

//        //we need to save the node before
//        ListNode beforeAll = head;
//        for (int i = 1; i < left - 1; i++) {
//            beforeAll = beforeAll.next;
//        }
//
//        //we need to save the node after
//        ListNode afterAll = head;
//        for (int i = 0; i < right; i++) {
//            afterAll = afterAll.next;
//        }
//
//        ListNode current = head;
//        for (int i = 1; i < left; i++) {
//            current = current.next;
//        }
//
//        ListNode beginningOfInnerList = current;
//
//        ListNode prev = afterAll;
//        ListNode next;
//
//        int index = left;
//        while (current.next != null && index <= right) {
//            ListNode temp = current.next;
//            current.next = prev;
//            prev = current;
//            current = temp;
//            index++;
//
//        }
//
//        beforeAll.next = beginningOfInnerList;
//
//        return head;

        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (left > 1) {
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (right > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            right--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;

    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
