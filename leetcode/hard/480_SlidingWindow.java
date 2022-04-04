import java.util.Arrays;

/*
    2022-04-04
    [Leetcode][Hard] 480. Sliding Window Median
*/
class SlidingWindow {
    /*
        broute force로 풀면
        Time Limit Exceeded

        to be implemented ...
    */
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medArr = new double[nums.length-k+1];

        if ( nums.length==1 ) {
            medArr[0] = nums[0];
            return medArr;
        }

        for(int i=0; i<nums.length-k+1; i++) {
            int[] tmp = Arrays.copyOfRange(nums, i, i+k);

            Arrays.sort(tmp);

            double median;
            if ( k%2==0 ) {
                median = ((double)tmp[k/2]/2) + ((double)tmp[k/2-1]/2);  // (double)(변수) / 2 로 해야 됨. (double)(변수/2) 로하면 이미 소수점 round 됨.
            } else {
                median = (double)(tmp[k/2]);
            }
            // System.out.println( ((double)tmp[k/2]/2)  );
            // System.out.println( tmp[k/2-1]/2 );
            medArr[i] = median;
        }
        return medArr;
    }

    public static void main(String[] args) {
        SlidingWindow sw = new SlidingWindow();
        // int[] nums = {2147483647,2147483647};
        // int k=2;
        // double[] res = sw.medianSlidingWindow(nums, k);
        // System.out.println(Arrays.toString(res));

        int[] nums = {1, 4, 2, 3};
        int k = 4;
        double[] res = sw.medianSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
    
}
