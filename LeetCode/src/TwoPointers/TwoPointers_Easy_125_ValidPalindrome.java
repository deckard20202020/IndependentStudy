package TwoPointers;

public class TwoPointers_Easy_125_ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean answer = isPalindrome(s);
        System.out.println(answer);
    }

    private static boolean isPalindrome(String s) {

        //I should be able to convert the characters to lowercase
        //and skip the non-alphanumberic as I go through the string
        //not before I process it.

        //remove non alphanumeric characters
        String string = s.replaceAll("[^a-zA-Z0-9]", "");

        //make all lowercase
        string = string.toLowerCase();

        //edge case checks
        if (string.length() == 0 || string.length() == 1) {
            return true;
        }

        //use left pointer and right pointer to make sure values are the same
        int left = 0;
        int right = string.length() -1;
        //stop when left pointer == right pointer
        //this will account for the odd length string
        while ( left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}
