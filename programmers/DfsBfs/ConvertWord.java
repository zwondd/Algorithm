/*
    2021-10-15
    [Programmers][Graph][Lv2] 단어변환
*/
package DfsBfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConvertWord {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        // map.put(begin, 0);
        for(int i=0; i<words.length; i++) {
            if ( words[i].equals(begin) ) continue;
            map.put(words[i], 100);
        }
        Queue<String> q = new LinkedList<>();

        q.add(begin);

        while( !q.isEmpty() ) {
            String tmpWord = q.poll();

            /*
                begin != target 고려안해도 되지만, 
                words 배열안에 begin 있을 경우 고려해줘야함.
            */
            int tmpWordCnt = ( map.containsKey(tmpWord) ) ? map.get(tmpWord) : 0;

            if ( tmpWord.equals(target) ) {
                answer = tmpWordCnt;
                break;
            }

            for(int i=0; i<words.length; i++) {
                int diffCnt=0;
                if ( words[i].equals(tmpWord) ) continue;

                for(int j=0; j<words[i].length(); j++) {
                    if ( tmpWord.charAt(j) != words[i].charAt(j) ) {
                        diffCnt++;
                    }
                }
                // if ( diffCnt!=1 ) continue;
                if ( diffCnt>1 ) continue;

                if (  tmpWordCnt+1 < map.get(words[i]) ) {
                    map.replace(words[i], tmpWordCnt+1);
                    q.add(words[i]);
                }
            }
        }
        return answer;
    }


    
    /*
        다른 풀이
    */
    static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }
    public int solution2(String begin, String target, String[] words) {
        int n = words.length, ans = 0;

        Queue<Node> q = new LinkedList<>();

        boolean[] visit = new boolean[n];
        q.add(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }

        return ans;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++ cnt > 1) return false;
            }
        }

        return true;
    }    

    public static void main(String[] args) {
        ConvertWord cw = new ConvertWord();
        System.out.println(cw.solution("hit", "hot", new String[]{"hit", "hot"} ));
    }
    
}
