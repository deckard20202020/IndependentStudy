package Citadel;

public class VisitingCities {
    public static void main(String[] args) {
        //red line = regular
        //blue line = express

        int[] red = {1,6,9,5};
        int[] blue = {5,2,3,10};
        int blueCost = 8;

        int[] answer = minimumCost(red, blue, blueCost);
        for(int n : answer){
            System.out.println(n);
        }
    }

    private static int[] minimumCost(int[] red, int[] blue, int blueCost) {

        int l = red.length;
        int[] answer = new int[l];
        int currMinBlue = blueCost;
        int currMinRed = 0;

        for (int i = 0; i < l; i++) {
            answer[i] = Math.min(red[i] + currMinRed, blue[i] + currMinBlue);
            int nexMinRed = Math.min(currMinRed + red[i], currMinBlue + blue[i]);
            int nextMinBlue = Math.min(nexMinRed + blueCost, currMinBlue + blue[i]);

            currMinRed = nexMinRed;
            currMinBlue = nextMinBlue;
        }

        return answer;

    }
}
