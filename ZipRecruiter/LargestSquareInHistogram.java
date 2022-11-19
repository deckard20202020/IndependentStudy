package ZipRecruiter;

public class LargestSquareInHistogram {
    public static void main(String[] args) {

        int[] heights = {1, 2, 3, 2, 1};
        int answer = maxSquare(heights);
        System.out.println(answer);
    }

    private static int maxSquare(int[] heights) {
        int answer = 0;

        int[] areas = new int[heights.length];
        areas[0] = 1;

        for (int i = 1; i < heights.length; i++) {
            int withLeft = 0;
            if (heights[i - 1] <= heights[i]) {
                withLeft = 1;
            }
            areas[i] = Math.max(1, areas[i -1] + withLeft);
        }

        for (int i = 0; i < areas.length; i++) {
            answer = (int) Math.max(answer, Math.pow(areas[i], 2));
        }

        return answer;
    }
}
