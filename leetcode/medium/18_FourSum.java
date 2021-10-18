/*
    2021-10-18
    [Leetcode][Medium] 18. 4Sum
*/
import java.util.*;

class FourSum {
    List<List<Integer>> uniqueQuad = new ArrayList<>();
    boolean[] visit;

    // To be implemented,,,
    public List<List<Integer>> fourSum(int[] nums, int target) {
        visit = new boolean[nums.length];
        for(int i=0; i<nums.length; i++) {
            Arrays.fill( visit, false);
            checkSum(new ArrayList<>(),0,i, nums, target);
        }
        return uniqueQuad;
    }

    private void printList(List<Integer> list) {
        for(int j=0; j<list.size(); j++) {
            System.out.print(list.get(j) + " ");
        }
        System.out.println();
    }

    private void checkSum(List<Integer> list, int sum, int idx, int[] nums, int target) {
        System.out.println("sum : " + sum + " idx : " + idx + " nums[i] : " + nums[idx]);
        if ( list.size() == 4 ) {
            
            if ( sum==target ) {
                System.out.println("=== sum==target : " + sum+ " " + target);
                printList( list );
                uniqueQuad.add(list);
            }
            return;
        }

        visit[idx] = true;
        sum+=nums[idx];
        list.add(nums[idx]);

        int tmpIdx = list.size()-1;
        for(int i=idx+1; i<nums.length; i++) {
            if ( visit[i] == false ) {
                // System.out.println( "tmp Idx : " + tmpIdx );
                checkSum(list, sum, i, nums, target);
                visit[i] = false;
                list.remove(tmpIdx);
            }
        }
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> result =  fs.fourSum(nums, target);
        for(int i=0; i<result.size(); i++) {
            for(int j=0; j<result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
