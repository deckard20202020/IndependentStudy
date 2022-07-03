package SlidingWindow;

public class SlidingWindow_Medium_1423_MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
//        int [] cardPoints = {1,2,3,4,5,6,1};
//        int k = 3;
        int[] cardPoints = {96,90,41,82,39,74,64,50,30};
        int k = 8;
        int answer = maxScore(cardPoints, k);
        System.out.println(answer);
    }

    private static int maxScore(int[] cardPoints, int k) {;

        //idea
            //we could find the sum of the entire array
            //then we could find the minimum in a window of size k
            //subtract this window minimum from the entire sum = answer
        //O(n)

        //base cases
        if (k == 0) {
            return 0;
        }

        //find sum of entire array
        int totalSum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            totalSum = totalSum + cardPoints[i];
        }

        //base case
        if (k > cardPoints.length) {
            return totalSum;
        }

        //update k
            //we are looking for min, then subtracting
            //not looking for max
        k = cardPoints.length - k;

        //find first temp sum
        int tempSum = 0;
        for (int i = 0; i < k; i++) {
            tempSum = tempSum + cardPoints[i];
        }

        int minSum = tempSum;

        for (int i = 1; i < cardPoints.length; i++) {
            //make sure we don't go out of bounds
            if (i + k <= cardPoints.length) {
                //subtract the value on our left
                tempSum = tempSum - cardPoints[i - 1];
                //add the value on the right
                tempSum = tempSum + cardPoints[i + k - 1];
                //update our minSum
                minSum = Math.min(minSum, tempSum);
            }

        }

        return totalSum - minSum;
    }
}
