package PracticeExam_22_2_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class D_TopologicalSorting {
    public static void main(String[]args) throws FileNotFoundException {
//        The first line contains two integers N and M (N is the number of the subjects, M is the number of the limitations).
//                The next M lines contain pairs si, ui, which describe the order of subjects: subject si must be studied before ui.
//                Further there is a sequence of N unique numbers ranging from 1 to N — the proposed study plan.

//        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\PracticeExam_22_2_13\\test.txt");
//        Scanner scanner = new Scanner((file));

//        //sum of all numbers between 1 and n
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        String[] nums = line.split(" ");

        int[] numbers = new int[nums.length];
        for (int i = 0; i< numbers.length; i++){
            numbers[i] = Integer.parseInt(nums[i]);
        }

        // number input
        Integer numberOfSubjects = numbers[0];
        Integer numberOfLimitations = numbers[1];

        String result = "YES";
        //quick check
        if (numberOfSubjects <=1 || numberOfLimitations == 0){
            result = "YES";
        } else{
            //map containing all the rules
            HashMap<Integer, List<Integer>> parents = new HashMap<Integer, List<Integer>>();

            //read the limitations
            for (int j =0; j < numberOfLimitations; j++){
                line = scanner.nextLine();

                nums = line.split(" ");

                numbers = new int[nums.length];
                for (int i = 0; i< numbers.length; i++){
                    numbers[i] = Integer.parseInt(nums[i]);
                }

                int firstSubject = numbers[0];
                int secondSubject = numbers[1];

                if (!parents.containsKey(firstSubject)){
                    parents.put(firstSubject, new ArrayList<>());
                    parents.get(firstSubject).add(secondSubject);
                } else {
                    parents.get(firstSubject).add(secondSubject);
                }

            }

            //read the list
            line = scanner.nextLine();
            nums = line.split(" ");
            int[] order = new int[numberOfSubjects];
            for (int i = 0; i < numberOfSubjects; i++){
                order[i] = Integer.parseInt(nums[i]);
            }

            //iterate through order and make sure each one is ok
            for (int i = 0; i < order.length; i++ ){
                for (int j = i+1; j < order.length-1; j++){
                    if (parents.containsKey(order[j]) && parents.get(order[j]).contains(order[i])){
                        result = "NO";
                        break;
                    }
                }
            }



        }

        System.out.println(result);
    }

}
