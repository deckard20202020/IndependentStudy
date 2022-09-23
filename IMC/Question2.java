package IMC;

import java.util.*;

public class Question2 {
    public static void main(String[] args) {

        int[] arrival = {0,0,1,4};
        int[] street = {0,1,1,0};

        int[] answer = getResult(arrival, street);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static int[] getResult(int[] arrival, int[] street) {

        //if no car in previous second, 1st ave goes
        //if car passed on 1st ave, 1st ave goes
        //if car passed on main, main goes

        //street = 1 or 0
            //1 = 1st, 0 = main

        //base cases
        //no cars
        if (arrival == null || arrival.length == 0) {
            int[] a = new int[0];
            return a;
        }
        //one car
        if (arrival.length == 1) {
            int[] a = new int[1];
            a[0] = arrival[0];
            return a;
        }

        //store the first and last times that cars arrive
        int minTime = Integer.MAX_VALUE;
        int maxTime = Integer.MIN_VALUE;

        //map of time to cars
        HashMap<Integer, List<Integer>> timeToCars = new HashMap<>();
        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];
            minTime = Math.min(minTime, time);
            maxTime = Math.max(maxTime, time);
            if (timeToCars.containsKey(time)) {
                List<Integer> list = timeToCars.get(time);
                list.add(i);
                timeToCars.put(time, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                timeToCars.put(time, list);
            }
        }

        //queues for main st and 1st
        Queue<Integer> mainQ = new ArrayDeque<>();
        Queue<Integer> firstQ = new ArrayDeque<>();

        int currentTime = 0;
        boolean carPassedThroughFirst = false;
        boolean carPassedThroughMain = false;
        boolean carPassedInPrevSec = false;
        int[] answer = new int[arrival.length];

        //scroll through the time
        while (currentTime <= maxTime || !mainQ.isEmpty() || !firstQ.isEmpty()) {

            //get the list of cars that are coming through
            List<Integer> cars = timeToCars.get(currentTime);

            //add them to the appropriate queues
            if (cars != null) {
                for (Integer n : cars) {
                    if (street[n] == 0) {
                        mainQ.add(n);
                    } else {
                        firstQ.add(n);
                    }
                }
            }

                //if no cars passed or last car was on first
            if ((!carPassedInPrevSec) || carPassedThroughFirst) {
//            if ((!carPassedThroughFirst && !carPassedThroughMain) || carPassedThroughFirst) {
                //priority goes to first st.
                if (!firstQ.isEmpty()) {
                    int car = firstQ.poll();
                    answer[car] = currentTime;
                    carPassedThroughFirst = true;
                    carPassedThroughMain = false;
                    carPassedInPrevSec = true;
                } else if (!mainQ.isEmpty()){
                    int car = mainQ.poll();
                    answer[car] = currentTime;
                    carPassedThroughFirst = false;
                    carPassedThroughMain = true;
                    carPassedInPrevSec = true;
                }
            } else if (carPassedThroughMain) {
                //priority goes to main st.
                if (!mainQ.isEmpty()) {
                    int car = mainQ.poll();
                    answer[car] = currentTime;
                    carPassedThroughFirst = false;
                    carPassedThroughMain = true;
                    carPassedInPrevSec = true;
                } else if (!firstQ.isEmpty()){
                    int car = firstQ.poll();
                    answer[car] = currentTime;
                    carPassedThroughFirst = true;
                    carPassedThroughMain = false;
                    carPassedInPrevSec = true;
                }
            } else {
                carPassedInPrevSec = false;
            }

            if (!carPassedInPrevSec) {
                carPassedThroughFirst = false;
                carPassedThroughMain = false;
            }

            currentTime++;
        }
        
        return answer;
    }
}
