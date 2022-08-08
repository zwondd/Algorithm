/*
    2022-08-08
    [Leetcode][Easy] 461. Hamming Distance
*/
import java.util.*;

class Hamming {
    /*
     * Runtime: 2 ms, faster than 7.52% of Java online submissions for Hamming Distance.
     * Memory Usage: 41.5 MB, less than 13.15% of Java online submissions for Hamming Distance.
     */
    public int hammingDistance(int x, int y) {
        Queue<Integer> xl = new LinkedList<>();
        Queue<Integer> yl = new LinkedList<>();

        while( x>0 ) {
            xl.add(x%2);
            x/=2;
        }

        while( y>0 ) {
            yl.add(y%2);
            y/=2;
        }

        int xlen = xl.size();
        int ylen = yl.size();

        if ( xlen > ylen ) for (int i=0; i<xlen-ylen; i++) yl.add(0);
        else if ( xlen < ylen ) for( int i=0; i<ylen-xlen; i++ ) xl.add(0);

        for(Integer s : xl) { 
            System.out.print(s); 
        }
        System.out.println();
        for(Integer s : yl) { 
            System.out.print(s); 
        }
        System.out.println();

        int cnt = 0;
        while( !xl.isEmpty() ) {
            if ( xl.poll() != yl.poll() ) cnt++;
        }

        return cnt;
    }


    /*
     * Runtime: 1 ms, faster than 45.88% of Java online submissions for Hamming Distance.
     * Memory Usage: 41.7 MB, less than 8.85% of Java online submissions for Hamming Distance.
     */
    public int hammingDistance2(int x, int y) {
        x = x^y;
        int ans = 0;
        while (x>0) {
            ans += x%2;
            x = x>>1;
        }
        return ans;
    }

    /*
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
     * Memory Usage: 39.4 MB, less than 90.02% of Java online submissions for Hamming Distance.
     */
    public int hammingDistance3(int x, int y) {
        int xor = x^y;
        int count = 0;
        while(xor>0) {
            if ( (xor&1) == 1 ) {
                count++;
            }
            xor = xor>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        Hamming h = new Hamming();
        int res =  h.hammingDistance(1, 4);
        System.out.println(res);
    }
}