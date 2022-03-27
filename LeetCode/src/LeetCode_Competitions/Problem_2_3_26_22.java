package LeetCode_Competitions;


public class Problem_2_3_26_22 {
    public static void main (String args[]) {
//        5236. Minimum Deletions to Make Array Beautiful
//        You are given a 0-indexed integer array nums. The array nums is beautiful if:
//
//        nums.length is even.
//                nums[i] != nums[i + 1] for all i % 2 == 0.
//        Note that an empty array is considered beautiful.
//
//        You can delete any number of elements from nums. When you delete an element, all the elements to the right of the deleted element will be shifted one unit to the left to fill the gap created and all the elements to the left of the deleted element will remain unchanged.
//
//        Return the minimum number of elements to delete from nums to make it beautiful.
//        nums.length is even.
//        nums[i] != nums[i + 1] for all i % 2 == 0.
//        1 <= nums.length <= 105
//        0 <= nums[i] <= 105

//        int[] nums = {1,1,2,3,5};
//        =1
//        int[] nums = {1,1,2,2,3,3};
//        =2
//        int[] nums = {0,6,6,1,8,7};
//        =0
//        int[] nums = {0,1,5,4,2,4,7,2,3,0,3,0,0,9,7,5,9,4,3,9,9,2,1,6,3,1,0,7,6,6,6,0,1,7,1,9,4,9,3,3,4,5,0,3,8,7,1,8,4,5};
//        =4
        int[] nums = {1, 1, 1, 1};
//        =4
        int answer = minDeletion(nums);
        System.out.println(answer);
    }

    private static int minDeletion(int[] nums) {
        //we only have to scroll though the array every other index
        //nums are all positive
        //if you need to remove it make it a negative number
        //scroll through the array again and count the negative numbers

//        int count = 0;
//
//        //edge cases
//        if (nums == null || nums.length==0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return 1;
//        }

        //idea 1
        //make a linked list.
        //scroll through the list and remove appropriate nodes
        //check if length of list is odd
            //then remove one more
//        ListNode[] nums2 = new ListNode[nums.length];
//        for (int i = 0; i < nums.length; i++){
//            ListNode n = new ListNode(nums[i]);
//            nums2[i] = n;
//        }
//
//        List<ListNode> list = Arrays.asList(nums2);
//
//        LinkedList<ListNode> linkedList = new LinkedList<>(list);
//        for (int i = 0; i < linkedList.size()-1; i++) {
//            if (linkedList.get(i) == linkedList.get(i + 1) && i%2 ==0) {
//                linkedList.get(i).next = linkedList.get(i).next.next;
//                count++;
//            }
//        }
//
//        //make sure length of list is even
//        if (linkedList.size() %2 != 0) {
//            count ++;
//        }

        //idea 3
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int index = 0;
//        for (Integer n : nums) {
//            map.put(n, index);
//            index ++;
//        }
//
//        //scroll through the hashmap and remove the necessary stuff
//        for (Integer key : map.keySet()) {
//            if (map.get(key) % 2 == 0 && map.get(key + 1) == map.get(key)) {
//                map.remove(map.)
//            }
//        }
//        so, O(n) sol, iterate from 0 to n-1 indices.
//        maintain a cnt variable beginning at 0. the cnt variable represents 'deletions' from the array.
//        so, you'd have to check if i-cnt%2==0 instead of i%2==0,
//        and the elements at i and i+1 are equal (if so add one to cnt). output cnt
        //idea 2
//        for (int i = 0; i < nums.length -1; i++) {
//            if (nums[i] == nums[i+1]) {
//                nums[i+1] = -1;
//                count++;
//                i++;
//                i++;
//            } else {
//                i++;
//            }
//        }
//
//        //still need to make sure list is even
//        if ((nums.length - count)%2 !=0){
//            count++;
//        }

        //help from competative coding team
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            if ((i-count)%2==0 && nums[i] == nums[i+1]) count++;
        }
        if((n-count)%2==1) count++;


        return count;
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
