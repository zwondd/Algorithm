/*
    2022-04-01
    [Leetcode][Easy] 412. Fizz Buzz
*/
import java.util.*;

class FizzBuzz {
    /*
        Runtime: 3 ms, faster than 28.36% of Java online submissions for Fizz Buzz.
        Memory Usage: 48.4 MB, less than 51.39% of Java online submissions for Fizz Buzz.       
    */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            if ( i%3==0 && i%5==0 ) {
                list.add("FizzBuzz");
            } else if ( i%3==0 ) {
                list.add("Fizz");
            } else if ( i%5==0 ) {
                list.add("Buzz");
            } else {
                list.add(i+"");
            }
        }

        return list;
    }
}
