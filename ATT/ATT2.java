package ATT;

import java.util.ArrayList;
import java.util.List;

public class ATT2 {
    public static void main(String[] args){
        List<Integer> signalOne = new ArrayList<>();
        signalOne.add(1);
        signalOne.add(2);
        signalOne.add(3);
        signalOne.add(4);
        signalOne.add(1);
        List<Integer>signalTwo = new ArrayList<>();
        signalTwo.add(5);
        signalTwo.add(4);
        signalTwo.add(3);
        signalTwo.add(4);
        signalTwo.add(1);
        int answer = updateTimes(signalOne, signalTwo);
        System.out.println(answer);

    }

    private static int updateTimes(List<Integer> signalOne, List<Integer> signalTwo) {
        int max = Integer.MIN_VALUE;
        int oneLength = signalOne.size();
        int twoLength = signalTwo.size();
        int smallLength = Math.min(oneLength, twoLength);
        int firstReading = 0;
        int secondReading = 0;
        int count = 0;

        for (int i = 0; i < smallLength; i++) {
            firstReading = signalOne.get(i);
            secondReading = signalTwo.get(i);

            if (firstReading == secondReading) {
                if (firstReading > max) {
                    max = Math.max(max, firstReading);
                    count += 1;
                }
            }
        }

        return count;
    }
}
