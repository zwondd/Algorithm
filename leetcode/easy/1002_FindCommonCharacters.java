/*
    2021-12-14
    [Leetcode][Easy] 1002. Find Common Characters
*/
import java.util.*;

class FindCommonCharacters {
    /*
        Runtime: 2 ms, faster than 97.32% of Java online submissions for Find Common Characters.
        Memory Usage: 39.1 MB, less than 86.33% of Java online submissions for Find Common Characters.
    */
    public List<String> commonChars(String[] words) {
        int[] base = new int[26];
        List<String> str = new ArrayList<>();

        for(char c : words[0].toCharArray() ) {
            base[c-'a']++;
        }

        for(int i=1; i<words.length; i++) {
            int[] temp = new int[26]; // temp 배열 항상 초기화 되어야함

            for( char c: words[i].toCharArray() ) {
                temp[c-'a']++;
            }

            for(int k=0; k<26; k++) {
                base[k] = Math.min(base[k], temp[k]);
            }
        }

        for(int i=0; i<26; i++) {
            if ( base[i]>0 ) {
                for(int j=0; j<base[i]; j++) {
                    str.add(Character.toString((char)('a'+i)));
                }
            }
        }

        return str;
    }
    
}
