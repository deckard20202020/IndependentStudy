public class problemC_CodeCleanups {
    public static void main(String[]args){

//        O(n)


//        5
//        1 45 65 84 346
//
//        4

//        int n = 5;
//        int[] pushes = {1, 45,65,84, 346};
//
//        int numberOfPushes = howManyPushes(n, pushes);
//
//        System.out.println(numberOfPushes);
//
//        3
//        310 330 350
//
//        3

        int n = 3;
        int[] pushes = {310, 330, 350};

        int numberOfPushes = howManyPushes(n, pushes);

        System.out.println(numberOfPushes);

    }

    private static int howManyPushes(int n, int[] pushes) {
        int counter = 0;

        int value = pushes[0];

        for (int i = 1; i < pushes.length; i++) {
            if (pushes[i]-value < 20) {
                continue;
            } else {
                counter++;
                value = pushes[i];
            }
        }

        //increase counter by one for end of year
        counter++;

        return counter;
    }


}
