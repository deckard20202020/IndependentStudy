package PracticeExam_22_2_20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class A_ArrayOfDiscord {
    public static void main(String[]args) throws FileNotFoundException {


        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\PracticeExam_22_2_20\\test.txt");
        Scanner scanner = new Scanner((file));
//
//        Scanner scanner = new Scanner(System.in);
//
        // number input
        Integer n = Integer.parseInt(scanner.nextLine());

        //String input
        String string = scanner.nextLine();

        String[] strings = string.split("\\s+");
        int[] numbers = new int[strings.length];

        //make a hashMap key = length, value = list of integers with that length
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //make an array of all the digits
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
            int length = strings[i].length();
            if (!map.containsKey(length)) {
                List<Integer> list = new ArrayList<>();
                list.add(numbers[i]);
                map.put(length,list );
            } else {
                map.get(length).add(numbers[i]);
            }
        }

        boolean canISwitchOrder = false;

        //find a key in the hashmap whose list has more than one element
        for(Integer key: map.keySet()) {
            if(map.get(key).size() > 1) {
                List l = map.get(key);
                System.out.println("test");
//                Integer first = l.get(0);
//                Integer second = l.get(1);

                //manipulate the numbers

                //put the one back in the array

                //change boolean
                canISwitchOrder = true;

                break;
            }
        }

        if (!canISwitchOrder) {
            System.out.println("impossible");
        } else {
            //print your answer
        }




    }
}
