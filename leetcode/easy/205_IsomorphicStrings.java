/*
    2021-10-18
    [Leetcode][Easy] 205. Isomorphic Strings
*/
import java.util.*;

class IsomorphicStrings {

    /*
        my solution 
        Runtime: 15 ms, faster than 32.19% of Java online submissions for Isomorphic Strings.
        Memory Usage: 38.9 MB, less than 74.04% of Java online submissions for Isomorphic Strings.
    */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            if ( map.containsKey(s.charAt(i)) == true && t.charAt(i) != map.get(s.charAt(i)) ) {
                return false;
            }
            if ( map.containsKey(s.charAt(i)) == false && map.containsValue(t.charAt(i)) ) {
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings is = new IsomorphicStrings();
        boolean res = is.isIsomorphic("egg", "add");
        System.out.println(res);

        res = is.isIsomorphic("foo", "bar");
        System.out.println(res);

        res = is.isIsomorphic("paper", "title");
        System.out.println(res);

        res = is.isIsomorphic("badc", "baba");
        System.out.println(res);
    }
    
}
