package DynamicProgramming;

public class Testing {
    public static void main (String[] args) {

        String text1 = "abcde";
        String text2 = "ace";



        int answer = longestCommonSubsequence(text1, text2);
        System.out.println(answer);
    }

    private static int longestCommonSubsequence(String text1, String text2) {

        //check edge cases
        if (text1.length() == 0 || text2.length() == 0
            || text1 == null || text2 == null) {
            return 0;
        }

        int answer = 0;

        int text1Length = text1.length();
        int text2Length = text2.length();

        int [][] array = new int[text1Length + 1][text2Length + 1];

        for (int i = 1; i < text1Length + 1; i++) {
            for (int j = 1; j < text2Length + 1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    array[i][j] = array[i -1][j-1] + 1;
                } else {
                    array[i][j] = Math.max(array[i-1][j], array[i][j-1]);
                }
            }
        }

        answer = array[text1Length][text2Length];

        return answer;

    }
}
