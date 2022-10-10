package Bloomberg;

public class BloombergPractice1 {
    public static void main(String[] args) {
        int num = 1112244455;
        int answer = encode(num);
        System.out.println(answer);
    }

    private static int encode(int num) {

        String stringNum = "" + num;
        int count = 1;
        char prev = stringNum.charAt(0);
        String answer = "";

        for (int i = 1; i < stringNum.length(); i++) {
            if (stringNum.charAt(i) == prev) {
                count++;
            } else {
                answer = answer + "" + count + "" + prev;
                prev = stringNum.charAt(i);
                count = 1;
            }
        }

        answer = answer + "" + count + "" + prev;

        return Integer.parseInt(answer);
    }
}
