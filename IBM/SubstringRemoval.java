package IBM;

public class SubstringRemoval {

    public static void main(String[] args) {

//        String seq = "BBABBA";
        String seq = "AABBBAB";
        int answer = getMinLength(seq);
        System.out.println(answer);

    }

    public static int getMinLength(String seq) {

        int answer = seq.length();

        answer = helper(seq, answer);
        return answer;
    }

    private static int helper(String seq, int answer) {

        int ab = Integer.MAX_VALUE;
        int bb = Integer.MAX_VALUE;
        if (seq.contains("AB")) {
            seq = seq.replace("AB", "");
            ab = helper(seq, seq.length());
        }

        if (seq.contains("BB")) {
            seq = seq.replace("BB", "");
            bb = helper(seq, seq.length());
        }

        return Math.min(seq.length(), Math.min(ab, bb));

    }
}
