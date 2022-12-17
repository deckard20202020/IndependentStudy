package Walmart;

public class MakePalindrome {
    public static void main(String[] args) {

        String string = "aabc";
        String answer = getPalindrome(string);
        System.out.println(answer);

    }

    public static String getPalindrome(String s) {
        // Make a copy of the string
        char[] arr = s.toCharArray();

        // Change the middle letters
        if (arr.length % 2 == 1) {
            // Odd length: change the middle letter
            int mid = arr.length / 2;
            arr[mid] = getSmallestLetter(arr[mid], arr[arr.length - mid - 1]);
        } else {
            // Even length: change the two middle letters
            int mid1 = arr.length / 2 - 1;
            int mid2 = arr.length / 2;
            arr[mid1] = getSmallestLetter(arr[mid1], arr[arr.length - mid1 - 1]);
            arr[mid2] = getSmallestLetter(arr[mid2], arr[arr.length - mid2 - 1]);
        }

        // Change the remaining letters
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                arr[i] = getSmallestLetter(arr[i], arr[arr.length - i - 1]);
                arr[arr.length - i - 1] = arr[i];
            }
        }

        // Return the resulting palindrome
        return new String(arr);
    }

    // Helper function to get the lexicographically smallest letter
    private static char getSmallestLetter(char c1, char c2) {
        return c1 < c2 ? c1 : c2;
    }
}
