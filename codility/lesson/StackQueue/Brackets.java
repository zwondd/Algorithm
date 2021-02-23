/**
 * 21-02-23
 * 7_StacksAndQueues_Brackets
 */ 

package codility.lesson.StackQueue;

import java.util.*;

class Solution {
    // My Solution 1 46min (100%) O(N)
    public int solution1(String S) {
        HashMap<String, String> map = new HashMap<String,String>();
        map.put(")","(");
        map.put("}","{");
        map.put("]","[");

        Stack<String> st=new Stack<String>();
        char[] chs=S.toCharArray();
        int i=0;

        while(i<chs.length) {
            if ( chs[i]==')' || chs[i]=='}' || chs[i]==']' ) {
                if ( st.empty() ) {
                    return 0;
                }
                String comp=st.pop();
                if ( !map.get(Character.toString(chs[i])).equals(comp) ) {
                    return 0;
                }
            } else {
                st.push(Character.toString(chs[i]));
            }
            i++;
        }

        if ( !st.empty() ) {
            return 0;
        }
        
        return 1;
    }

    // Other Solution 
    // https://wildcatsy.blogspot.com/2017/06/codility-lesson-7-stacks-and-queues.html
    int solution(String S) {
        if(S.length()%2 != 0) return 0;
        ArrayList<Character> R = new ArrayList<Character>();
              
        for( char i : S.toCharArray()){
         if( i == '(' || i == '{' || i == '[') R.add(i);
         if( i == ')' || i == '}' || i == ']'){
             if(R.size() == 0) return 0;
             char chk=' ';
      
            switch(i){
                case ')' : chk = '('; break;
                case '}' : chk = '{'; break;
                case ']' : chk = '['; break;
            }
          
            if(R.get(R.size()-1) != chk) return 0;
            R.remove(R.size()-1);
         } 
        }
        if(!R.isEmpty()) return 0;
        return 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String tc = "{[()()]}";
        System.out.println(s.solution(tc));

        String tc2= "([)()]";
        System.out.println(s.solution(tc2));

    }
}
