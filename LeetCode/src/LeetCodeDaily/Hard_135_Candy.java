package LeetCodeDaily;

public class Hard_135_Candy {
    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        int answer = candy(ratings);
        System.out.println(answer);
    }

    private static int candy(int[] ratings) {

        //idea
        //scroll left to right keeping track of what we would need in a left to right array
        //scroll right to left keeping track of what we would need in a right to left array
        //sum the max of each of these two arrays at each index to get our answer

        int[] leftToRight = new int[ratings.length];
        int[] rightToLeft = new int[ratings.length];
        for (int i = 0; i < leftToRight.length; i++) {
            leftToRight[i] = 1;
            rightToLeft[i] = 1;
        }

        //go left to right
        for (int i = 1; i < leftToRight.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            }
        }

        //go right to left
        for (int i = rightToLeft.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            }
        }

        //update the total
        int total = 0;
        for (int i = 0; i < leftToRight.length; i++) {
            total = total + Math.max(leftToRight[i], rightToLeft[i]);
        }

        return total;
    }
}
