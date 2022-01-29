public class BinarySearch_Easy_167_TwoSum2 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length-1;
            int[] solution = new int[2];

            while (left < right){

                if (numbers[left] + numbers[right] == target){
                    solution[0] = left + 1;
                    solution[1] = right + 1;
                    return solution;
                }
                if (numbers[left] + numbers[right] < target){
                    left = left + 1;
                }
                if (numbers[left] + numbers[right] > target){
                    right = right - 1;
                }
            }
            return solution;

        }
    }
}
