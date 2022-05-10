/*
    2022-05-10
    [Leetcode][Medium] 238. Product of Array Except Self
*/
class ProductArray {
    /*
        Solution ) https://bcp0109.tistory.com/284
        Runtime: 3 ms, faster than 40.63% of Java online submissions for Product of Array Except Self.
        Memory Usage: 58.8 MB, less than 6.44% of Java online submissions for Product of Array Except Self.
    */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        res[0]=1;
        for(int i=1; i<nums.length; i++) {
            res[i]=res[i-1]*nums[i-1];
        }
        int acc=1;
        for(int i=nums.length-2; i>=0; i--) {
            acc *= nums[i+1];
            res[i] *= acc;
        }
        return res;
    }
}
