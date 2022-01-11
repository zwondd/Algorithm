/*
    2022-01-11
    [Leetcode][Easy] 290. Word Pattern
*/
import java.util.*;

class WordPattern {
    /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Word Pattern.
        Memory Usage: 36.9 MB, less than 78.46% of Java online submissions for Word Pattern.
    */
    public boolean wordPattern(String pattern, String s) {
        char[] pat = pattern.toCharArray();
        boolean[] checked = new boolean[pat.length];
        String[] words = s.split(" ");

        if ( pat.length != words.length ) {
            return false;
        }

        for(int i=0; i<pat.length; i++) {
            if ( checked[i] == true ) continue;
            checked[i] = true;

            for(int j=i+1; j<pat.length; j++) {
                if ( checked[j] == false ) {
                    if ( pat[i]==pat[j] && !words[i].equals(words[j]) ) return false;
                    if ( pat[i]!=pat[j] && words[i].equals(words[j]) ) return false;
                    if ( pat[i]==pat[j] && words[i].equals(words[j]) ) checked[j]=true;
                }

                // if ( checked[j] == false && pat[i]==pat[j] ) {
                //     if ( !words[i].equals(words[j]) ) {
                //         return false;
                //     }
                //     checked[j] = true;
                // }
            }
        }
        return true;
    }

    /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Word Pattern.
        Memory Usage: 36.9 MB, less than 68.72% of Java online submissions for Word Pattern.    
    */
    public boolean wordPattern2(String pattern, String s) {
        Map<Character, String> mapChar = new HashMap<>(); // <a,dog>, <b,cat>
        Map<String, Character> mapStr = new HashMap<>(); // <dog,a>, <cat,b>

        String[] arr = s.split(" ");
        if ( pattern.length() != arr.length ) return false;

        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = arr[i];
            if ( mapChar.get(c) == null ) {
                if ( mapStr.containsKey(str) ) {
                    return false;
                } else {
                    mapChar.put(c, str);
                    mapStr.put(str, c);
                }
            } else {
                if ( !mapChar.get(c).equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
