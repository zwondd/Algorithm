/*
    2021-09-20
    [Leetcode][Easy] 953. Verifying an Alien Dictionary
    DP
*/
class AlienDictionary {
    /*
        Runtime: 1 ms, faster than 57.87% of Java online submissions for Verifying an Alien Dictionary.
        Memory Usage: 39.2 MB, less than 33.65% of Java online submissions for Verifying an Alien Dictionary.
    */
    public boolean isAlienSorted(String[] words, String order) {
        int[] ord = new int[26];
        for(int i=0; i<order.length(); i++) {
            ord[order.charAt(i)-'a'] = i;
        }

        for(int j=0; j<words.length-1; j++) {
            String pre = words[j];
            String next = words[j+1];

            int lastIdxOfNewWord = next.length()-1;

            for(int k=0; k<pre.length(); k++) {
                if ( k>lastIdxOfNewWord) {
                    return false;
                }

                if ( ord[pre.charAt(k)-'a'] < ord[next.charAt(k)-'a'] ) {
                    break;
                } else if ( ord[pre.charAt(k)-'a'] >  ord[next.charAt(k)-'a'] ) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        AlienDictionary ad = new AlienDictionary();
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println( ad.isAlienSorted(words, order) );
    }
}
