// 21-08-01
// DP 풀이
// 참고 ) https://real-012.tistory.com/194
import java.util.*;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> h = new HashSet<>();
        for( String str: wordDict ) h.add(str);

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1; i<=s.length(); i++) {
            for(int j=i-1; j>=0; j--) {
                if ( dp[j] && h.contains(s.substring(j,i)) ) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];        
    }


    public static void main(String[] args) {
        WordBreak w = new WordBreak();

        String s = "leetcode";
        List<String> list =Arrays.asList(new String[]{"leet","code"});
        System.out.println( w.wordBreak(s, list) );

        String s2 = "catsandog";
        List<String> list2 =Arrays.asList(new String[]{"cats","dog","sand","and","cat"});
        System.out.println( w.wordBreak(s2, list2) );
    }
    
}
