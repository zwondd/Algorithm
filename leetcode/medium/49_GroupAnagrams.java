/*
    2022-01-24
    [Leetcode][Medium] 49. Group Anagrams
*/
import java.util.*;
class GroupAnagrams {
    /*
        Runtime: 16 ms, faster than 38.05% of Java online submissions for Group Anagrams.
        Memory Usage: 53.5 MB, less than 24.15% of Java online submissions for Group Anagrams.
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagram = new LinkedList<>();
        Map<String, List<String>> key = new HashMap<>();

        for(String s : strs) {
            char[] cArr = s.toCharArray();
            Arrays.sort(cArr);
            String ordered = String.valueOf(cArr);

            if ( key.containsKey(ordered) ) {
                key.get(ordered).add(s);
            } else {
                List<String> list = new LinkedList<>();
                list.add(s);
                key.put(ordered, list);
            }
        }
        for(List<String> keyList : key.values() ) {
            anagram.add(keyList);
        }
        return anagram;


        /*
            Runtime: 14 ms, faster than 48.88% of Java online submissions for Group Anagrams.
            Memory Usage: 53.1 MB, less than 36.15% of Java online submissions for Group Anagrams.
        */
        // List<List<String>> aa = new LinkedList<>(key.values());
        // return aa;
    }
}
