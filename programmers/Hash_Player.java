/*
    2021-09-28
    [Programmers][Hash][Lv1] 완주하지 못한 선수
*/

import java.util.HashMap;
import java.util.Arrays;

class HashPlayer {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort( participant );
        Arrays.sort( completion );

        answer = participant[participant.length-1];

        for(int i=0; i<completion.length; i++) {
            if ( !participant[i].equals(completion[i]) ) {
                answer = participant[i];
                break;
            }
        }
        
        return answer;
    }

    /*
        다른 풀이
    */
    public String solution2(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hm = new HashMap<>();
        for( String player : participant ) hm.put(player, hm.getOrDefault(player, 0)+1 );
        for( String player : completion ) hm.put(player, hm.get(player)-1);

        for( String key : hm.keySet() ) {
            if ( hm.get(key) != 0 ) {
                answer = key;
            }
        }
        
        return answer;
    }
    
}
