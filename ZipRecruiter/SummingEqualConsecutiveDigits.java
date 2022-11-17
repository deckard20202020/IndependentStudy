package ZipRecruiter;

public class SummingEqualConsecutiveDigits {
    public static void main(String[] args) {

//        String num = "113";
        String num = "19938832066";
        String answer = sumEqualConsDigits(num);
        System.out.println(answer);
    }

    private static String sumEqualConsDigits(String num) {
        String answer = "";

        //base cases
        if (num.length() == 0 || num.length() == 1) {
            return num;
        }

        String left = String.valueOf(num.charAt(0));

        for (int i = 1; i < num.length(); i++) {
            int count = Integer.valueOf(String.valueOf(num.charAt(i)));
            if (String.valueOf(num.charAt(i)).equals(left)) {
                while (String.valueOf(num.charAt(i)).equals(left)) {

                    count += Integer.valueOf(String.valueOf(num.charAt(i)));
                    left = String.valueOf(num.charAt(i));
                    i++;

                }
                i--;
            }



            answer = answer + String.valueOf(count);
        }

        return answer;
    }
}
