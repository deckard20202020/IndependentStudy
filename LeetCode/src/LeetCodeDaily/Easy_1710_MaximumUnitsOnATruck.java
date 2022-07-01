package LeetCodeDaily;

import java.util.Arrays;
import java.util.Comparator;

public class Easy_1710_MaximumUnitsOnATruck {
    public static void main(String[] args) {
        //int[][] boxTypes = {{1,3}, {2,2}, {3,1}};
        int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};
        //int truckSize = 4;
        int truckSize = 10;
        int answer = maximumUnits(boxTypes, truckSize);
        System.out.println(answer);

    }

    private static int maximumUnits(int[][] boxTypes, int truckSize) {


        //initial idea
        //order the array by their unit size (second parameter)
        //how can we sort like this?
        //KNOW THIS-Lamda Functions
        //nlogn
        //start picking up the boxes until we are full
        //second idea
        //put all the boxes in a priority queue by unit size (second)
        //start picking off the boxes until we are full

        //sort the array with a lambda function
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> -o[1]));

        int total = 0;
        int numOfBoxes = boxTypes.length;
        int index = 0;

        while ( index < numOfBoxes && truckSize > 0) {
            //grab the box at our index
            int amountToAdd = boxTypes[index][1];
            //add it to our total
            total = total + amountToAdd;
            //reduce our truckSize
            truckSize--;
            //remove a box from that group of boxes
            boxTypes[index][0]--;
            //check to see if we need to move along to grab another box
            if (boxTypes[index][0] <= 0) {
                index++;
            }

        }

        return total;
    }


}
