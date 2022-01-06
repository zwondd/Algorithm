import java.util.ArrayList;

/*
    2022-01-06
    [Leetcode][Medium] 373. Find K Pairs with Smallest Sums
*/
import java.util.*;

class FindPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> smaller;
        
        if ( nums1.length * nums2.length <= k ) {
            for(int i=0; i<nums1.length; i++) {
                for(int j=0; j<nums2.length; j++) {
                    smaller = new ArrayList<>();
                    smaller.add(nums1[i]);
                    smaller.add(nums2[j]);
                    pairs.add(smaller);
                }
            }
            return pairs;
        }

        int posX=0;
        int posY=0;

        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums1[posX]);
        tmp.add(nums2[posY]);
        pairs.add(tmp);
        
        boolean increaseX = false;
        boolean increaseY = false;

        while( pairs.size() < k ) {
            smaller = new ArrayList<>();
            //System.out.println(nums1[posX] + " -- " + nums2[posY] );
            
            if ( posX+1>=nums1.length && posY+1>=nums2.length ) {
                break;
            }
            if ( posX+1>=nums1.length ) {
                smaller.add(nums1[posX]);
                smaller.add(nums2[++posY]);
                pairs.add(smaller);
                continue;
            }

            if ( posY+1>=nums2.length ) {
                smaller.add(nums1[++posX]);
                smaller.add(nums2[posY]);
                pairs.add(smaller);
                continue;
            }

            if ( increaseX && posX-1>=0 ) {
                if ( nums1[posX-1]+nums2[posY+1] <= nums1[posX+1]+nums2[posY] ) {
                    smaller.add(nums1[--posX]);
                    smaller.add(nums2[posY++]);
                    pairs.add(smaller);

                    increaseX = false;
                    increaseY = true;
                    continue;
                } else {
                    smaller.add(nums1[++posX]);
                    smaller.add(nums2[posY]);
                    pairs.add(smaller);

                    increaseX = true;
                    increaseY = false;
                    continue;
                }
            }

            if ( increaseY && posY-1>=0 ) {
                if ( nums1[posX+1]+nums2[posY-1] <= nums1[posX]+nums2[posY+1] ) {
                    smaller.add(nums1[++posX]);
                    smaller.add(nums2[--posY]);
                    pairs.add(smaller);

                    increaseX = true;
                    increaseY = false;
                    continue;
                } else {
                    smaller.add(nums1[posX]);
                    smaller.add(nums2[++posY]);
                    pairs.add(smaller);

                    increaseX = false;
                    increaseY = true;
                    continue;
                }
            }

            //System.out.println("smaller : " + (nums1[posX+1]+nums2[posY]) + " vs " + (nums1[posX]+nums2[posY+1]) );
            if ( nums1[posX+1]+nums2[posY] <= nums1[posX]+nums2[posY+1] ) {
                smaller.add(nums1[++posX]);
                smaller.add(nums2[posY]);
                pairs.add(smaller);

                increaseX = true;
                increaseY = false;
                continue;
            } 
            if ( nums1[posX+1]+nums2[posY] > nums1[posX]+nums2[posY+1] ) {
                smaller.add(nums1[posX]);
                smaller.add(nums2[++posY]); 
                pairs.add(smaller);

                increaseX = false;
                increaseY = true;
                continue;
            }
            //System.out.println( posX + " .. " + posY );
        }

        return pairs;
    }
}
