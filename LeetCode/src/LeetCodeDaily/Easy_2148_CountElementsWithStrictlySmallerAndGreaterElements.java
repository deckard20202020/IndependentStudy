package LeetCodeDaily;

public class Easy_2148_CountElementsWithStrictlySmallerAndGreaterElements {
    public static void main(String[] args) {

        int[] nums = {11,7,2,15};
        int answer = countElements(nums);
        System.out.println(answer);
    }

    private static int countElements(int[] nums) {

        //ideas
        //1 could sort the array
        //nlogn
        //could find the max and min
        //and then iterate through the array
        //n

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int count = 0;

        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        for (int n : nums) {
            if(n < max && n > min) {
                count++;
            }
        }

        return count;
    }
}
