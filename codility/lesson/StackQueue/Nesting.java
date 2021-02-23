/**
 * 21-02-23
 * 7_StacksAndQueues_Nesting
 */ 
package codility.lesson.StackQueue;

import java.util.*;

public class Nesting {

    // My Solution 1 11min (100%) O(N)
    public int solution(String S) {
        Stack<String> nested=new Stack<String>();
        char[] chs=S.toCharArray();

        for(int i=0; i<chs.length; i++) {
            if ( chs[i]=='(' ) {
                nested.push(Character.toString(chs[i]));
            } else {
                if ( nested.empty() ) return 0;
                nested.pop();
            }
        }
        if ( !nested.empty() ) return 0;
        return 1;
    }

    public static void main(String[] args) {
        Nesting nest = new Nesting();
        String test = "(()(())())";
        System.out.println(nest.solution(test));
    }
    
}
