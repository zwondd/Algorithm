/*
    2021-10-17
    [Leetcode][Easy] 202. Happy Number
*/
import java.util.HashSet;

class HappyNumber {
    /*
        solution 참조
        : sum으로 나온 값이 이전에 나온 값이 반복 됨. (cycle을 이룰 경우)
        https://haningya.tistory.com/38

        Runtime: 1 ms, faster than 87.16% of Java online submissions for Happy Number.
        Memory Usage: 36.5 MB, less than 43.72% of Java online submissions for Happy Number.

    */
    public boolean isHappy(int n) {
        int nextNum = n;
        int sum=0;
        HashSet<Integer> hs = new HashSet<>();

        while( sum!= 1 ) {
            sum=0;
            while( nextNum/10 != 0 ) {
                sum += Math.pow(nextNum%10, 2);
                nextNum/=10;
            }
            sum += Math.pow(nextNum, 2);
            System.out.println(sum);
            if ( sum == 1 ) return true;
            if ( hs.contains(sum) ) return false;

            nextNum = sum;
            hs.add(sum);
        }
        return false;
    }
    public static void main(String[] args) {
        HappyNumber hp = new HappyNumber();
        System.out.println( hp.isHappy(19) );
        System.out.println( hp.isHappy(2) );
        System.out.println( hp.isHappy(7) );
    }
}
