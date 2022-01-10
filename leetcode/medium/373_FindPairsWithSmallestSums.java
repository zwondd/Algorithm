/*
    2022-01-06
    [Leetcode][Medium] 373. Find K Pairs with Smallest Sums
*/
import java.util.*;

class FindPairsWithSmallestSums {
    /*
        Runtime: 30 ms, faster than 19.04% of Java online submissions for Find K Pairs with Smallest Sums.
        Memory Usage: 109.8 MB, less than 5.11% of Java online submissions for Find K Pairs with Smallest Sums.
        ref) https://www.programmerall.com/article/196979118/
    */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // using priority queue (heap)

        List<List<Integer>> res = new ArrayList<>();
        if ( nums1.length == 0 || nums2.length == 0 ) {
            return res;
        }
        PriorityQueue<int[]> minPq = new PriorityQueue<>((a,b) -> {
            return nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]];
        });
        Set<Integer>[] set = new Set[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            set[i] = new HashSet<>();
        }
        minPq.add(new int[]{0,0});
        set[0].add(0);
        while( k>0 && minPq.size()>0 ) {
            int[] curr = minPq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[curr[0]]);
            list.add(nums2[curr[1]]);
            res.add(list);

            if ( curr[0] < nums1.length-1 && !set[curr[0]+1].contains(curr[1])) {
                minPq.add(new int[]{curr[0]+1, curr[1]});
                set[curr[0]+1].add(curr[1]);
            }
            if ( curr[1] < nums2.length-1 && !set[curr[0]].contains(curr[1]+1)) {
                minPq.add(new int[]{curr[0], curr[1]+1});
                set[curr[0]].add(curr[1]+1);
            }
            k--;
        }
        return res;
    }
}
