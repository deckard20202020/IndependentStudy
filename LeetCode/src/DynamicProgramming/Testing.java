package DynamicProgramming;

public class Testing {
    public static void main (String[] args) {
        int n = 3;

        int answer = findTotals(n);
        System.out.println(answer);
    }

    private static int findTotals(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int[] total = new int[n + 1];

//         0   0
//         1   1
//         2   11
//             2
//         3   111
//             12
//             21
//         4   1111
//             121
//             112
//             211
//             22

        total[0] = 0;
        total[1] = 1;
        total[2] = 1;

        for (int i =2; i < total.length; i++) {
            total = numberOfWays(i, total);
        }

        return total[total.length-1];
    }

    private static int[] numberOfWays(int i, int[] total) {
        total[i] = total[i-1] + total[i-2];
        return total;
    }
}
