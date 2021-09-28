/*
    2021-09-28
    [Programmers][Sort][Lv2] K번째 수 
*/

import java.util.*;

public class Sort_Biggest {

    /*
        1. 더 큰값 계산 로직
        2. quickSort 혹은 다른 sort 방법으로 정렬
        3. 해당 배열의 int 값들 String으로 append
    */
    public String solution(int[] numbers) {
        String answer = "";
        return answer;
    }

    private int[] quickSort( int[] nums, int left, int right) {
        
    }

    private int getBigger(int a, int b) {
        char[] chrA = Integer.toString(a).toCharArray();
        char[] chrB = Integer.toString(b).toCharArray();

        int minLen = Math.min( chrA.length, chrB.length );

        for(int i=0; i<minLen; i++) {
            if ( chrA[i] < chrB[i] ) {
                return b;
            }
        }

        if ( chrA.length<chrB.length ) return a;
        else return b;
    }
    
}
