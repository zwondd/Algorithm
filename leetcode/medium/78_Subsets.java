/*
    2021-09-02
    [Leetcode][Medium] 78. Subsets
    Backtracking
*/
import java.util.*;

class Subsets {
    /*
        DFS
        Runtime: 3 ms, faster than 6.40% of Java online submissions for Subsets.
        Memory Usage: 40.1 MB, less than 8.49% of Java online submissions for Subsets.
    */
    // List<List<Integer>> sublist = new ArrayList<>();

    // public List<List<Integer>> subsets(int[] nums) {
    //     sublist.add(new ArrayList<>());
    //     dfs(0, new ArrayList<>(), nums);
    //     return sublist;
    // }

    // public void dfs(int k, List<Integer> sub, int[] nums) {
    //     if ( k == nums.length ) {
    //         return;
    //     }

    //     for(int i=k; i<nums.length; i++) {
    //         List<Integer> list1 = new ArrayList<>();
    //         list1.addAll(sub);
    //         list1.add(nums[i]);
    //         sublist.add(list1);
            
    //         dfs(i+1, list1, nums);
    //     }

    // }

    /*
        Backtracking

        Runtime: 1 ms, faster than 54.87% of Java online submissions for Subsets.
        Memory Usage: 39.1 MB, less than 70.96% of Java online submissions for Subsets.
    */  
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        res.add(new ArrayList<>(list));
        for(int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, res, list, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] input = {1,2,3};
        List<List<Integer>> list = s.subsets(input);
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    
}
