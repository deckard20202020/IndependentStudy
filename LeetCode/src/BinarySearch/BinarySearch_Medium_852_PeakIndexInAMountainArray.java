package BinarySearch;

public class BinarySearch_Medium_852_PeakIndexInAMountainArray {
    public static void main(String[] args) {

//        int[] arr = {3,4,5,1};
//        int[] arr = {3,4,5,1};
        int[] arr = {3,5,3,2,0};
        int answer = peakIndexInMountainArray(arr);
        System.out.println(answer);
    }

    private static int peakIndexInMountainArray(int[] arr) {

        //we don't need to check if the array is less than
        //arr is guaranteed to be a mountain array

        //idea 1
        //could just do a linear search to find the maximum

        //idea 2
        //binary search

        // //check edges
        // if (arr[0] > arr[1]) {
        //     return 0;
        // }
        // if (arr[arr.length - 1] < arr[arr.length - 2]) {
        //     return arr.length - 1;
        // }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                //we have found it
                return mid;
            }

            if (arr[mid - 1] > arr[mid]) {
                //go left
                right = mid;
            } else {
                //go right
                left = mid + 1;
            }

        }

        return -1;
    }
}
