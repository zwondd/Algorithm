/*
    2022-08-10
    [Leetcode][Medium] 752. Open the Lock
*/
import java.util.*;

class OpenLock {
    /*
     * Runtime: 460 ms, faster than 28.20% of Java online submissions for Open the Lock.
     * Memory Usage: 79.7 MB, less than 66.12% of Java online submissions for Open the Lock.
     */
    public int openLock(String[] deadends, String target) {
        String start = "0000";

        if ( target.equals(start)) return 0;

        Set<String> deadSet = new HashSet<>();
        for(String dead : deadends) deadSet.add(dead);

        if ( deadSet.contains(start) ) return -1;

        Queue<String> q = new LinkedList<>();
        q.offer(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        int cnt = 0;

        while( !q.isEmpty() ) {
            cnt++;
            int qSize = q.size();

            for(int i=0; i<qSize; i++) {
                String cur = q.poll();
                for(int j=0; j<4; j++) {
                    for(int k=-1; k<=2; k+=2) {
                        char[] curChr = cur.toCharArray();
                        curChr[j] = (char)(((curChr[j]-'0')+k+10)%10 + '0');
                        String next = new String(curChr);
                        if ( next.equals(target)) return cnt;
                        if ( deadSet.contains(next) || visited.contains(next) ) continue;
                        visited.add(next);
                        q.offer(next);
                    }
                    
                }
            }
        }
        return -1;
    }
}
