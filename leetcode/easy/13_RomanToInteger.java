/*
    2022-01-20
    [Leetcode][Easy] 13. Roman to Integer
*/
import java.util.*;

class RomanToInteger {
    /*
        Runtime: 18 ms, faster than 11.08% of Java online submissions for Roman to Integer.
        Memory Usage: 47.1 MB, less than 5.26% of Java online submissions for Roman to Integer.
    */
    public int romanToInt(String s) {
        int sum=0;
        
        char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] value = {1, 5, 10, 50, 100, 500, 1000};

        char[] str = s.toCharArray();
        
        Map<String, Integer> subtr = new HashMap<>();
        subtr.put("IV", 4);
        subtr.put("IX", 9);
        subtr.put("XL", 40);
        subtr.put("XC", 90);
        subtr.put("CD", 400);
        subtr.put("CM", 900);

        int i=0;
        while( i<str.length ) {
            if ( i+1<str.length ) {
                String check = Character.toString(str[i]) + Character.toString(str[i+1]);
                if ( subtr.containsKey(check) ) {
                    sum+=subtr.get(check);
                    i+=2;
                    continue;
                }
            }

            for(int j=0; j<symbol.length; j++) {
                if ( symbol[j] == str[i] ) {
                    sum+=value[j];
                    i++;
                    break;
                }
            }
        }
        return sum;
    }

    /*
       Runtime: 11 ms, faster than 30.94% of Java online submissions for Roman to Integer.
        Memory Usage: 42.4 MB, less than 32.68% of Java online submissions for Roman to Integer. 
    */
    int res = 0;
    public int romanToInt2(String s) {
        String[] r = {"IV", "IX", "XL", "XC", "CD", "CM" };
        int[] v = {4, 9, 40, 90, 400, 900};

        for(int i=0; i<6; i++) {
            s = replaceRoman(s, r[i], v[i]);
        }
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if ( c=='I' ) res+=1;
            else if ( c=='V' ) res+=5;
            else if ( c=='X' ) res+=10;
            else if ( c=='L' ) res+=50;
            else if ( c=='C' ) res+=100;
            else if ( c=='D' ) res+=500;
            else if ( c=='M' ) res+=1000;
        }
        return res;
    }

    public String replaceRoman(String s, String keyword, int val) {
        while(s.indexOf(keyword) != -1) {
            res +=val;
            s=s.replace(keyword, "");
        }
        return s;
    }
}
