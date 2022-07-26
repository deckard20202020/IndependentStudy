package Optiver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ThirdLatestDate {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\Optiver\\ThirdLatestDateTest.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfDates = Integer.parseInt(scanner.nextLine());

        Set<String> set = new HashSet<>();
        PriorityQueue<Date> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < numberOfDates; i++) {
            String dateString = scanner.nextLine();
            set.add(dateString);
        }
        for (String dateString : set) {
            String[] splitDate = dateString.split("-");
            int year = Integer.valueOf(splitDate[2]);
            int month = Integer.valueOf(splitDate[1]);
            int day = Integer.valueOf(splitDate[0]);
            Date date = new Date(year, month, day);
            pq.add(date);
        }

        Date answer = null;
        for (int i = 0; i < 3; i++) {
            answer = pq.poll();
        }

        String result = "";
        String year = String.valueOf(answer.year);
        String month = String.valueOf(answer.month);
        String day = String.valueOf(answer.day);
        result = day + "-" + month + "-" + year;

        System.out.println(result);


    }

    public static class Date implements Comparable<Date>{
        int year;
        int month;
        int day;

        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public int compareTo(Date date) {
            if (this.year > date.year) {
                return 1;
            } else if (this.year < date.year) {
                return -1;
            } else if (this.month > date.month) {
                return 1;
            } else if (this.month < date.month) {
                return -1;
            } else if (this.day > date.day) {
                return 1;
            } else if (this.day < date.day) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
