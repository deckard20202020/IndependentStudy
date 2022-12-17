package Walmart;

import java.util.*;

public class AlertUsingSameKey {
    public static void main(String[] args) {
        String[] keyName = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] keyTime = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};

        List<String> answer = alertNames(keyName, keyTime);

        for (String string : answer) {
            System.out.println(string);
        }
    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {

        //put all the people into a hashmap
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            if (map.containsKey(keyName[i])) {
                //convert keyTime
                int time = convertTime(keyTime[i]);
                List<Integer> list = map.get(keyName[i]);
                list.add(time);
                map.put(keyName[i], list);
            } else {
                int time = convertTime(keyTime[i]);
                List<Integer> list = new ArrayList<>();
                list.add(time);
                map.put(keyName[i], list);
            }
        }

        //order all the lists
        for (String key : map.keySet()) {
            List<Integer> list = map.get(key);
            Collections.sort(list);
            map.put(key, list);
        }

        HashSet<String> set = new HashSet<>();
        List<String> answer = new ArrayList<>();

        //find anyone who clocked in three times in
        for (String key : map.keySet()) {
            List<Integer> times = map.get(key);
            if (times.size() >=3) {
                for (int i = 2; i < times.size(); i++) {
                    int first = times.get(i - 2);
                    int third = times.get(i);
                    if (third - first <= 60) {
                        set.add(key);
                    }
                }
            }
        }

        for (String string : set) {
            answer.add(string);
        }

        Collections.sort(answer);

        return answer;
    }

    public static int convertTime(String time) {
        String[] arr = time.split(":");
        int answer = 0;

        int hours = Integer.valueOf(arr[0]);
        hours = hours * 60;
        answer = answer + hours;

        int minutes = Integer.valueOf(arr[1]);
        answer = answer + minutes;

        return answer;
    }
}
