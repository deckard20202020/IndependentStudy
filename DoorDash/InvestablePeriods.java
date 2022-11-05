package DoorDash;

public class InvestablePeriods {
    public static void main(String args[]) {

        int n = 4;
//        int[] price = {1, 2, 3, 2};
//        int[] price = {1, 1, 1, 1};
//        int[] price = {4,5,3,3,1};
        int[] price = {2,2,1,5,1};
//        int max_price = 3;
//        int min_price = 2;
//        int max_price = 1;
//        int min_price = 1;
//        int min_price = 3;
//        int max_price = 5;
        int min_price = 1;
        int max_price = 2;
        int answer = contInvestablePeriods(price, max_price, min_price);
        System.out.println(answer);
    }

    private static int contInvestablePeriods(int[] price, int max_price, int min_price) {

        int answer = 0;

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (left != price.length - 1) {

            //update the max and min
            min = Math.min(min, (Math.min(price[left], price[right])));
            max = Math.max(max, (Math.max(price[left], price[right])));

            //we have an investable array
            if (min == min_price && max == max_price) {
                answer ++;
                //move the right if we can
                if (right < price.length - 1) {
                    right++;
                } else {
                    //move the left
                    left++;
                    //are the left and right the same?
                    if (left == right) {
                        max = price[left];
                        min = price[right];
                        //another check
                        if (max == max_price && min == min_price) {
                            answer++;
                        }
                    }
                }
                continue;
            }

            //if one qualifies and not at the end
//            if (min == min_price || max == max_price) {
            if ((min < max_price || max > min_price) && right < price.length - 1) {
                //move the right one
                right++;
                continue;
            } else {
                //nothing qualifies
                //move the whole window forward
                left++;
                right = left;
                min = price[left];
                max = price[right];
            }
        }

        return answer;
    }
}
