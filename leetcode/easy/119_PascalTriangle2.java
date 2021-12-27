/*
    2021-12-27
    [Leetcode][Easy] 721. Accounts Merge
*/
import java.util.*;


class PascalTriangle2 {
    /*
        Runtime: 1 ms, faster than 75.45% of Java online submissions for Pascal's Triangle II.
        Memory Usage: 36.7 MB, less than 76.05% of Java online submissions for Pascal's Triangle II.
    */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rows = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        if ( rowIndex == 0 ) {
            rows.add(1);
            return rows;
        }

        for(int i=1; i<=rowIndex; i++) {
            // System.out.println("====");
            q.add(1);
            for(int j=0; j<i-1; j++) {
                int first = q.poll();
                int second = q.peek();
                q.add(first+second);
                // System.out.println( first+second );
            }
            q.poll();
            q.add(1);
        }

        while( !q.isEmpty() ) {
            rows.add(q.poll());
        }
        return rows;
    }

    /*
        Other solution
        Runtime: 1 ms, faster than 75.45% of Java online submissions for Pascal's Triangle II.
        Memory Usage: 36.6 MB, less than 85.43% of Java online submissions for Pascal's Triangle II.
    */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=rowIndex+1;i++){       //Find each row separately
            List<Integer> newList = new ArrayList<>();
            newList.add(0,1);  //The first number is 1
            for(int k=1;k<i-1;k++){
                newList.add(k,list.get(k)+list.get(k-1));
            }
            if(i>1)newList.add(1);
            list = newList;
        }
        return list;
    }

    public static void main(String[] args) {
        PascalTriangle2 pt = new PascalTriangle2();
        List<Integer> res = pt.getRow2(1);
        for(int i=0; i<res.size(); i++) {
            System.out.println(res.get(i));
        }

    }
}
