package Cisco;

public class test {
    public static void main(String[] args) {
        String s = "abcd";
        int answer = alphOrder(s);
        System.out.println(answer);
    }

    private static int alphOrder(String s) {

        for (int i = 1; i < s.length(); i++) {
//            int n = Integer.valueOf(s.charAt(i));
//            int prev = Integer.valueOf(s.charAt(i - 1));
            char n = s.charAt(i);
            char prev = s.charAt(i - 1);

            if (prev > n) {
                return i;
            }
        }

        return 0;
    }
}
