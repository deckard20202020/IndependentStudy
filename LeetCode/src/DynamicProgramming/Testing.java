package DynamicProgramming;

public class Testing {
    public static void main (String[] args) {

    int[] nums = {4,2,5,3};

        int answer = maxAlternatingSum(nums);
        System.out.println(answer);
    }

    private static int maxAlternatingSum(int[] nums) {

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = nums.length -1; i >=0; i--) {
            int tempEven = Math.max(sumOdd + nums[i], sumEven);
            int tempOdd = Math.max(sumEven - nums[i], sumOdd);
            sumEven = tempEven;
            sumOdd = tempOdd;
        }

        return sumEven;
    }
}
