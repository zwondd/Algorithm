/*
    2022-01-12
    [Leetcode][Meduim] 5. Longest Palindromic Substring
*/
import java.util.*;

class LogestPalindromicSubstring_2 {
    /*
        Runtime: 1510 ms, faster than 5.00% of Java online submissions for Longest Palindromic Substring.
        Memory Usage: 51.9 MB, less than 13.84% of Java online submissions for Longest Palindromic Substring.
    */
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();

        String maxPal = "";

        for(int i=0; i<=ch.length-1; i++) {
            for(int j=ch.length-1; j>=i; j--) {
                int start = i;
                int end = j;
                //System.out.println( " start " + start + " / end " + end );
                
                boolean isPalindromic = true;
                while( start<end ) {
                    //System.out.println( ch[start] + " /  " + ch[end] );
                    if ( ch[start++] != ch[end--] ) {
                        isPalindromic = false;
                        break;
                    }
                }

                if ( isPalindromic ) {
                    //System.out.println( " [isPalindromic] " + ch[i] + " / " + ch[j] );
                    //System.out.println(i + " , " + j );
                    //System.out.println(" start-end+1  : " + (end-start+1) + "// len : " + maxPal.length() );
                    
                    if ( j-i+1 > maxPal.length() ) {
                        maxPal = "";
                        for(int k=i; k<=j; k++) {
                            //System.out.print( Character.toString(ch[k]) );
                            maxPal+=ch[k];
                        }
                    }
                }
            }
        }
        return maxPal;
    }
}
