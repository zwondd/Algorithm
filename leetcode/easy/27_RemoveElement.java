// 21-03-04

package leetcode.easy;

class RemoveElement {
    // Runtime: 0 ms, 
    // Memory Usage: 39.3 MB
    public int removeElement(int[] nums, int val) {
        int left=0;
        int right=nums.length-1;
        int result=nums.length;

        while(left<=right) {  // fix 2
            if ( nums[left]== val ) {
                result--;
                if ( nums[right] != val ) {
                    nums[left]=nums[right];
                    nums[right]=val;
                } 
                right--;   // fix 1
            } else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveElement r=new RemoveElement();
        int[] t1={0,1,2,2,3,0,4,2};
        int val=2;

        int res=r.removeElement(t1, val);
        for(int i=0; i<t1.length; i++) 
            System.out.print(t1[i]+ " ");
        System.out.println();
        System.out.println(res);

    }
}
