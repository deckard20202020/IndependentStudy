package ATT;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ATT4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Challenger,12/01/2018,Sam");
        list.add("Prius,10/03/2011,Angie");
        list.add("Challenger,6/15/1985,Angie");
        list.add("Challenger,01/08/1965,Sam");
        list.add("Corvette,01/01/1963,Angie");
        String answer = doProject(list);
        System.out.println(answer);
    }

    private static String doProject(List<String> list) {

        //create tables that we would probably use sql to query
        HashMap<String, String> modelToMake = createModelToMake();
        HashMap<String, String> modelToSpeed = createModelToSpeed();

        HashMap<String, Integer> ownersToQuantity = new HashMap<>();
        HashMap<LocalDate, String> datesToModel = new HashMap<>();
        HashMap<String, String> ownersToDates = new HashMap<>();
        String ownerWithMostCars = "";


        String[] entry;
        for (String s : list) {

            //split each entry in the input
            entry = s.split(",");
            String model = entry[0];
            LocalDate date = createDate(entry[1]);
            String owner = entry[2];

            ownersToQuantity.put(owner, ownersToQuantity.getOrDefault(owner, 0) +1);

            //update current dates and models
            if (ownersToDates.keySet().contains(owner)) {
                //if we have already stored a car for the owner we need
                //to check to see if this entry is a newer car
                LocalDate currDate = createDate(ownersToDates.get(owner));
                if (date.isAfter(currDate)) {
                    ownersToDates.put(owner, entry[1]);
                    datesToModel.put(date, model);
                }
            } else {
                //otherwise this is the first car we have seen for that owner
                //so just store the info
                ownersToDates.put(owner, entry[1]);
                datesToModel.put(date, model);
            }

        }

        //I could probably avoid looping through this map by creating another hashmap and updating it
        //while looping thorugh the input data.  This loop is O(n) worst case though so while we would
        //save a loop, it wouldn't lower the Big O time complexity.  I decided to just save the space.
        ownerWithMostCars = findOwnerWithMostCars(ownersToQuantity);

        String owner = ownerWithMostCars;
        int maxNumCars = ownersToQuantity.get(ownerWithMostCars);
        String date = ownersToDates.get(ownerWithMostCars);
        String year = date.substring(6);
        String model = datesToModel.get(createDate(date));
        String make = modelToMake.get(model);
        String speed = modelToSpeed.get(model);



        return owner + " has " + maxNumCars + " vehicles and is currently driving a " + year + " " + make + " " + model + " that goes " + speed + " mph.";
    }

    private static String findOwnerWithMostCars(HashMap<String, Integer> ownersToQuantity) {

        String ownerWithMostCars = "";
        int max = Integer.MIN_VALUE;
        for (String s : ownersToQuantity.keySet()) {
            if (ownersToQuantity.get(s) > max) {
                ownerWithMostCars = s;
                max = Math.max(max, ownersToQuantity.get(s));
            }
        }

        return ownerWithMostCars;
    }

    private static HashMap<String, String> createModelToSpeed() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Camry", "100");
        map.put("Prius", "80");
        map.put("Corvette", "160");
        map.put("Challenger", "155");

        return map;
    }

    private static HashMap<String, String> createModelToMake() {

        HashMap<String, String> map = new HashMap<>();
        map.put("Camry", "Toyota");
        map.put("Prius", "Toyota");
        map.put("Corvette", "Chevrolet");
        map.put("Challenger", "Dodge");

        return map;
    }

    private static LocalDate createDate(String date) {
        String[] d = date.split("/");
        int month = Integer.valueOf(d[0]);
        int day = Integer.valueOf(d[1]);
        int year = Integer.valueOf(d[2]);

        return LocalDate.of(year, month, day);
    }


}
