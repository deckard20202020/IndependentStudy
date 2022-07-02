package DynamicProgramming;

public class DP_Medium_45_JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int answer = jump(nums);
        System.out.println(answer);
    }

    private static int jump(int[] nums) {

        //idea
        //can we start at the last index and
        //try to find the number of stops it takes to get here?
        //this will be the min of the number of stops it takes
        //to get to any index where current index - other index >= value at other index

        //We will use an array to store our answers for each step
        int[] answers = new int[nums.length];
        //initialize each entry of the array
        answers[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            answers[i] = Integer.MAX_VALUE;
        }

        return findJumps(nums.length - 1, nums, answers);

        //idea
        //we could also do this iteratively instead of recursively
    }

    private static int findJumps(int n, int[] nums, int[] answers) {

        //base case
        if (n == 0) {
            return 0;
        }
        //check the cache
        if (answers[n] != Integer.MAX_VALUE) {
            return answers[n];
        }

        //otherwise do our recursion
        return Math.min(answers[n], findJumps(n-1, nums, answers));
    }
}
