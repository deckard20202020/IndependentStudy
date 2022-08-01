package Optiver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\Optiver\\Question1.txt");
        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int day1 = 1;
        int day2 = 1;
        int month1 = 5;
        int month2 = 5;
        int year1 = 2010;
        int year2 = 2011;

        int answer = DaysBetween(year1, month1, day1, year2, month2, day2);
        System.out.println(answer);
    }

    private static int DaysBetween(int year1, int month1, int day1, int year2, int month2, int day2) {

        int total = 0;

        int daysDiff = day2 - day1 + 1;
        int daysTillEndOfMonth = calcDaysTillEndOfMonth(day1, month1, year1);
        int daysTillCurrentYear = calcDaysTillCurrYear(month1 + 1, year1, month2, year2);
        int daysTillCurrentMonth = calcDaysInCurrentYear(1, month2, year2);

        total = daysDiff + daysTillEndOfMonth + daysTillCurrentYear + daysTillCurrentMonth;

        return total;
    }

    private static int calcDaysTillEndOfMonth(int day1, int month1, int year1) {

        int daysInCurrMonth = DaysInMonth(month1, year1);
        return daysInCurrMonth - day1;
    }

    private static int calcDaysInCurrentYear(int month1, int month2, int year2) {

        int sum = 0;

        while (month1 < month2) {
            int days = DaysInMonth(month1, year2);
            sum = sum + days;
            month1++;
        }

        return sum;
    }

    private static int calcDaysTillCurrYear(int month1, int year1, int month2, int year2) {

        int sum = 0;

        while (year1 < year2) {
            while (month1 <= 12) {
                int days = DaysInMonth(month1, year1);
                sum = sum + days;
                month1++;
            }

            month1 = 1;
            year1++;
        }

        return sum;
    }

    private static int DaysInMonth(int month1, int year1) {

        int answer = 30;
        return answer;
    }
}
