package BinarySearch;

public class BinarySearch_Easy_278_BadVersion {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;

            while (left < right) {
                //look at this line
                int mid = left + (right - left) / 2;

                if (isBadVersion(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;

        }

    //need this method to get rid of errors
    //leetcode had an api we could hit.
    private boolean isBadVersion(int mid) {

            return true;
    }

}
