import java.util.Arrays;

/*
    2022-03-23
    [Leetcode][Medium] 31. Next Permutation
*/
class NextPermutation {
    /*
        Runtime: 3 ms, faster than 7.54% of Java online submissions for Next Permutation.
        Memory Usage: 43.7 MB, less than 53.10% of Java online submissions for Next Permutation.
    */
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-1; i>0; i--) {
            if ( nums[i-1]<nums[i] ) {
                int nextIdx=i;

                for(int j=i+1; j<nums.length; j++) {
                    if ( nums[j]>nums[i-1] && nums[j]<nums[nextIdx] ) {
                        nextIdx = j;
                    }
                }

                // swap
                int tmp = nums[i-1];
                nums[i-1]=nums[nextIdx];
                nums[nextIdx]=tmp;

                // sort
                // Arrays.sort(nums, i, nums.length-1);
                Arrays.sort(nums, i, nums.length); // toIndex is exclusive
 
                // System.out.println(Arrays.toString(nums)); // simple way to print array
                return;
            }
        }

        int[] tmpNums = nums.clone();
        for(int i=0; i<nums.length; i++) {
            nums[i] = tmpNums[nums.length-1-i];
        }
        return;
    }

    /*
        Runtime: 2 ms, faster than 23.86% of Java online submissions for Next Permutation.
        Memory Usage: 42.5 MB, less than 81.55% of Java online submissions for Next Permutation.
    */
    public void nextPermutation2(int[] nums) {
        int a = nums.length-2;
        while(a>=0 && nums[a]>=nums[a+1]) a--;

        if ( a!=-1 ) {
            int b = nums.length-1;
            while(nums[a]>=nums[b]) b--;
            swap(nums, a, b);
        }
        int start=a+1;
        int end=nums.length-1;
        while(start<end) {
            swap(nums, start++, end--);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    /*
        Runtime: 1 ms, faster than 84.67% of Java online submissions for Next Permutation.
        Memory Usage: 44 MB, less than 21.36% of Java online submissions for Next Permutation.
    */
    public void nextPermutation3(int[] nums) {
        int paNumIndex = -1;
        for (int i = nums.length - 1; i >0; i --){
            if (nums[i-1] < nums[i]){ 
                paNumIndex = i-1; 
                break; 
            } 
        } 
        if (paNumIndex != -1){ 
            int chNumIndex = -1;
            for (int i = nums.length - 1; i > paNumIndex; i --){
                if (nums[i] > nums[paNumIndex]){
                    chNumIndex = i;
                    break;
                }
            }
            int tmp = nums[paNumIndex];
            nums[paNumIndex] = nums[chNumIndex];
            nums[chNumIndex] = tmp;
        }
        int start = paNumIndex + 1, end = nums.length -1;
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }

    }//nextPermutation
}
