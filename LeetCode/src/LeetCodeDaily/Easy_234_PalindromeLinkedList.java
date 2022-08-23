package LeetCodeDaily;

import java.util.ArrayList;
import java.util.List;

public class Easy_234_PalindromeLinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean answer = isPalindrome(head);
        System.out.println(answer);
    }

    private static boolean isPalindrome(ListNode head) {

        //idea add items to list
        //check list with two pointers left and right
        //I think this is O(n) time
        //I think this is O(n) space

        ListNode node = head;
        List<Integer> list = new ArrayList<>();

        while (node.next != null) {
            list.add(node.val);
            node = node.next;
        }

        //add the last val
        list.add(node.val);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            if (list.get(left) != list.get(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
