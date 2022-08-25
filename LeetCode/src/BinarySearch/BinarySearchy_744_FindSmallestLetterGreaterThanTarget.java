package BinarySearch;

public class BinarySearchy_744_FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {

        char[] letters = {'c', 'f', 'j'};
        char target = 'a';

        char answer = nextGreatestLetter(letters, target);
        System.out.println(answer);
    }

    private static char nextGreatestLetter(char[] letters, char target) {

        //binary search O(logn)
        int left = 0;
        int right = letters.length;

        //target = c
        //letters = a, c, c, d, e

        while (left < right) {
            int mid = left + (right - left) / 2;
            //check to see if we have our goal
            if (letters[mid] <= target) {
                //go right
                left = mid + 1;
            } else {
                //go left
                right = mid;
            }
        }

        return letters[left % letters.length];

//         //linear
//         for (char c : letters) {
//             if (target < c) {
//                 return c;
//             }
//         }

//         return letters[0];
    }
}
