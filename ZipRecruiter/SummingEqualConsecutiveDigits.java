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

//        String left = String.valueOf(num.charAt(0));

        for (int i = 0; i < num.length(); i++) {
            int rightIndex = i + 1;
            int count = Integer.valueOf(String.valueOf(num.charAt(i)));
            boolean adding = false;

            while (rightIndex + 1 <= num.length() && String.valueOf(num.charAt(rightIndex)).equals(String.valueOf(num.charAt(i)))) {
                count += Integer.valueOf(String.valueOf(num.charAt(rightIndex)));
                rightIndex++;
                adding = true;

            }

            if (adding) {
                i = rightIndex - 1;
            }

            answer = answer + String.valueOf(count);
        }


        return answer;
    }
}
