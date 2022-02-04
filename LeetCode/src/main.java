public class main {

    public static void main (String args[]) {
        int[] array = {5,7,7,8,8,10};
        int target = 8;

        int[] result = searchRange(array, target);

        for (int j:result) {
            System.out.println(j);
        }

    }

        public static int[] searchRange(int[] nums, int target) {

            int[] result = new int[2];

            //check for empty array
            if(nums.length == 0) {
                result[0] = -1;
                result[1] = -1;
                return result;
            }

            //look for the first instance
            result[0] = firstInstance(nums, target);

            //look for the last instance
            result[1] = lastInstance(nums, target);

            return result;
        }

        public static int firstInstance(int[] nums, int target) {
            //initialize the index
            int index = -1;

            //initialize variables for your while
            int start = 0;
            int end = nums.length-1;

            //note here we need a <=
            while (start <= end) {
                int midpoint = start + (end - start) /2;

                if (nums[midpoint] >= target) {
                    //search left
                    end = midpoint - 1;
                } else {
                    start = midpoint + 1;
                }

                //update our index as we go along and find the number
                if (nums[midpoint] == target) {
                    index = midpoint;
                }
            }

            return index;

        }

        public static int lastInstance(int[] nums, int target) {
            //initialize the index
            int index = -1;

            //initialize variables for your while
            int start = 0;
            int end = nums.length-1;

            //note here we need a <=
            while (start <= end) {
                int midpoint = start + (end - start) /2;

                if (nums[midpoint] <= target) {
                    //search right
                    start = midpoint + 1;
                } else {
                    end = midpoint - 1;
                }

                //update our index as we go along and find the number
                if (nums[midpoint] == target) {
                    index = midpoint;
                }
            }

            return index;

        }
    }

