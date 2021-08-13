// 2021-08-13

class FindPeakElement {
    // success
    public int findPeakElement(int[] nums) {
       int ans = 0;
       for(int i=1; i<nums.length; i++) {
           if ( nums[i-1] < nums[i] ) {
               ans = i;
           }
       }
       return ans;
        
    }
}
