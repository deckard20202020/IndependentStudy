package PracticeExam_22_1_30;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProblemF_FishMonger {
    public static void main(String[]args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\PracticeExam_22_1_30\\test2.txt");
        Scanner scanner = new Scanner((file));

//        Scanner scanner = new Scanner(System.in);

        //First line
        String string = scanner.nextLine();
        String[] strings = string.split("\\s+");

        int numberOfFishToSell = Integer.parseInt(strings[0]);
        int numberOfFishmongers = Integer.parseInt(strings[1]);

        //second line
        string = scanner.nextLine();
        strings = string.split("\\s+");
        List<Integer> weightsOfFish = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            weightsOfFish.add(Integer.parseInt(strings[i]));
        }

        //list of the highest available prices in descending order
        List<Integer> prices = new ArrayList<>();

        //Hashmap of fisherman and how many fish they want to buy
        //key = fisherman value = #of fish want to buy
        HashMap<Integer, Integer> howManyFish = new HashMap<>();

        //Hashmap of fisherman and prices they want to pay
        //key = price paid value = fisherman
        HashMap<Integer, List<Integer>> pricePaid = new HashMap<>();

        //read each of the next lines
        for (int i = 0; i < numberOfFishmongers-1; i++) {
            string = scanner.nextLine();
            strings = string.split("\\s+");
            //add the price to the list of prices
            prices.add(Integer.parseInt(strings[1]));

            //hashmaps
            //howManyFish
            if (howManyFish.get(i + 1) == null) {
                howManyFish.put(i + 1, Integer.parseInt(strings[0]));
            }
            //howManyFish.get(amountOfSpaceJunk[i]).add(i);

            //pricePaid
            if (pricePaid.get(Integer.parseInt(strings[1])) == null) {
                pricePaid.put(Integer.parseInt(strings[1]), new ArrayList<Integer>());
            }
            pricePaid.get(Integer.parseInt(strings[1])).add(i + 1);

        }

        //sort the list of prices
        Collections.sort(prices, Collections.reverseOrder());

        int total = 0;

        //while I have fish to sell and there are people to sell them to
        while (numberOfFishToSell > 0 && howManyFish.size() > 0) {
            //get the highest price
            int highestPrice = prices.get(0);

            //find the fishmonger that will sell for that price
            List<Integer> list = pricePaid.get(highestPrice);
            int fishmonger = list.get(0);

            //check to see how many fish that fishmonger has to sell
            int fishToSell = howManyFish.get(fishmonger);

            //sell the fish
            //I have more fish than the monger wants
            if (numberOfFishToSell >= fishToSell) {
                numberOfFishToSell = numberOfFishToSell - fishToSell;
                int profit = 0;
                for (int i = 0; i < fishToSell; i++) {
                    profit = profit + (highestPrice * weightsOfFish.get(0));
                    weightsOfFish.remove(0);
                }
                total = total + profit;
                //update howManyFish
                howManyFish.remove(fishmonger);

                //update price paid
                //remove the first monger in the list
                pricePaid.get(highestPrice).remove(0);

                //if the list at that location in the hasmap is empty
                if (pricePaid.get(highestPrice).isEmpty()) {
                    //update the list of highest prices
                    prices.remove(0);

                }

            }else {
                numberOfFishToSell = 0;
                int profit = 0;
                for (int i = 0; i < fishToSell; i++) {
                    profit = profit + (highestPrice * weightsOfFish.get(0));
                    weightsOfFish.remove(0);
                }
                total = total + profit;
            }

        }
        //Should Be 66
        System.out.println(total);
    }

}
