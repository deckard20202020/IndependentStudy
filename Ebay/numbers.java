package Ebay;

public class numbers {
    public static void main(String[] args) {
        int[] numbers = {3,3,5,2,3};
        int answer = solution(numbers);
        System.out.println(answer);
    }

    private static int solution(int[] numbers) {

        int answer = 0;

        int index = findFirstIndex(numbers);

        while (index >= 0) {
            boolean hasAdded = false;
            int x = numbers[index];

            for (int j = index; j < numbers.length; j++) {

                if (numbers[j] >= x) {
                    numbers[j] = numbers[j] - x;

                } else {
                    answer = answer + x;
                    hasAdded = true;
                    break;
                }

            }

            if (!hasAdded) {
                answer = answer + x;
            }
            index = findFirstIndex(numbers);
        }

        return answer;
    }

    private static int findFirstIndex(int[] numbers) {

        int answer = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                return i;
            }
        }

        return -1;
    }
}
