/*
    2021-10-10
     [Leetcode][Easy] 118. Pascal's Triangle
*/

import java.util.*;
class PascalTriangle {
    /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
        Memory Usage: 36.8 MB, less than 71.81% of Java online submissions for Pascal's Triangle.
    */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> l = new ArrayList<>();
        l.add(1);
        list.add(l);
        if ( numRows==1 ) {
            return list;
        } 
        for(int i=2; i<=numRows; i++) {
            List<Integer> prev = list.get(list.size()-1);
            List<Integer> next = new ArrayList<>();

            next.add(1);
            for(int idx=0; idx<prev.size()-1; idx++) {
                next.add( prev.get(idx) + prev.get(idx+1) );
            }
            next.add(1);
            list.add(next);
        }
        return list;
    }

    /*
        other solution
    */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                } else {
                    int prev = result.get(i-1).get(j-1);
                    int next = result.get(i-1).get(j);
                    list.add(prev+next);
                }
            }
            result.add(list);
        }
        return result;
    }
    
}
