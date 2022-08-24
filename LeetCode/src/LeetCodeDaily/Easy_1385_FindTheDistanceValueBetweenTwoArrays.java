package LeetCodeDaily;

public class Easy_1385_FindTheDistanceValueBetweenTwoArrays {
    public static void main(String[] args) {

        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int d = 2;

        int answer = findTheDistanceValue(arr1, arr2, d);
        System.out.println(answer);
    }

    private static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        //this was listed as a binary search
        //not sure how we would use binary search to make it faster
        //this beats 88% of other submissions.
        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            boolean b = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    b = false;
                    break;
                }
            }
            if (b) {
                count++;
            }
        }

        return count;
    }
}
