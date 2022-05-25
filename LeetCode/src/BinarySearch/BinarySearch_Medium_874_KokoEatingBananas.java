package BinarySearch;

public class BinarySearch_Medium_874_KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

        int answer = minEatingSpeed(piles, h);
        System.out.println(answer);
    }

    private static int minEatingSpeed(int[] piles, int h) {

        //we iterate through the array so O(n) time
            //but we also itterate through the array logk times so O(n*logk)
        //we don't store any info other than variables so O(1) space

        //idea
        //we can only get rid of at most one pile per hour
        //h >= piles.length
        //The least amount of bananas we will need to eat per hour is 1
        //the greatest amount of bannanas we will need to eat per hour is the max of all the piles

        //iterate through the array and find the max of all the piles
        //use binary search between 1 and the max of the piles until we find
        //the minimum that will still work

        int left = 1;
        int right = 1;
        int mid = 0;
        for (int n : piles) {
            right = Math.max(right, n);
        }

        while (left < right) {

            mid = (left + right)/2;
            int hours = 0;

            //iterate over the piles and calculate the hours it takes us
            for (int n : piles) {
                hours += Math.ceil((double) n / mid);
            }

            //if we can make it with this number
            //go left
            if (hours <= h) {
                right = mid;
            } else {
                //if we cannot make it with this number
                //go right
                left = mid + 1;
            }

            //if we cannot make it with this number
            //go right
        }

        //once the left >= right
        //we want to return the right
        //which is the minumum workable answer
        return right;
    }
}
