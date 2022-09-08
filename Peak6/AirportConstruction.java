package Peak6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AirportConstruction {
    public static void main (String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\Peak6\\test.txt");

        Scanner scanner = new Scanner(file);
        //Scanner scanner = new Scanner(System.in);

        int[] landingTimes = {630, 645, 730, 1100};
        int[] takeOffTimes = {700, 845, 1015, 1130};
        //int[] takeOffTimes = {};
        //int[] takeOffTimes = {1119};
        //int[] takeOffTimes = {1200};
        int maxWaitTime = 20;
        int initialPlanes = 1;

        int answer = airportGates(landingTimes, takeOffTimes, maxWaitTime, initialPlanes);
        System.out.println(answer);
    }

    private static int airportGates(int[] landingTimes, int[] takeOffTimes, int maxWaitTime, int initialPlanes) {

        //update the answer to account for initial planes
        int answer = initialPlanes;
        int curr = initialPlanes;

        int i = 0;
        int j = 0;
        int numOfLanding = landingTimes.length;
        int numOfTakeOff = takeOffTimes.length;

        while (i < numOfLanding && j < numOfTakeOff) {
            int timeDiff = timeDiff(landingTimes[i], takeOffTimes[j]);
            if (timeDiff > maxWaitTime) {
                curr++;
                i++;
            } else if ( timeDiff < maxWaitTime) {
                curr--;
                j++;
            }

            answer = Math.max(answer, curr);
        }

        while (i < numOfLanding) {
            curr++;
            i++;
        }

        answer = Math.max(answer, curr);

        return answer;
    }

    private static int timeDiff(int landingTime, int takeOffTime) {
        int answer = 0;

        int landHours = landingTime/100;
        int landMinutes = landingTime % 100;
        int takeOffHours = takeOffTime/100;
        int takeOffMinutes = takeOffTime % 100;

        //answer = ((landHours * 60) + landMinutes) - ((takeOffHours * 60) + takeOffMinutes);
        answer = ((takeOffHours * 60) + takeOffMinutes) - ((landHours * 60) + landMinutes);

        return answer;
    }
}
