import java.util.Scanner;

public class problemB_BabyBites {
    public static void main(String[]args){

        //O(n)???

//        5
//        1 2 3 mumble 5

//        int n = 5;
//        String[] strings = {"1", "2", "3", "mumble", "5"};
//
//        String dtms = doesThisMakeSense(n, strings);
//
//        System.out.println(dtms);

//        makes sense
//
//        8
//        1 2 3 mumble mumble 7 mumble 8

//            int n = 8;
//            String[] strings = {"1", "2", "3", "mumble", "mumble", "7", "mumble", "8"};
//
//            String dtms = doesThisMakeSense(n, strings);
//
//            System.out.println(dtms);
//
//        something is fishy
//
//        3
//        mumble mumble mumble
        //
//        makes sense

//        int n = 3;
//        String[] strings = {"mumble", "mumble", "mumble"};
//
//        String dtms = doesThisMakeSense(n, strings);
//
//        System.out.println(dtms);

        Scanner scanner = new Scanner(System.in);

        // number input
        Integer n = Integer.parseInt(scanner.nextLine());

        //String input
        String string = scanner.nextLine();

        String[] strings = string.split("\\s+");

        String dtms = doesThisMakeSense(n, strings);

        System.out.println(dtms);

    }

    private static String doesThisMakeSense(int n, String[] strings) {

        if (strings.length != n) {
            return "something is fishy";
        }

        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == "mumble") {
                continue;
            } else {
                int number = Integer.parseInt(strings[i]);
                if (number == i +1) {
                    continue;
                } else {
                    return "something is fishy";
                }
            }

        }

        return "makes sense";
    }


}
