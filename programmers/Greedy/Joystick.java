/*
    2021-10-15
    [Programmers][Greedy][Lv2] 조이스틱
*/
package Greedy;

public class Joystick {
    /*
        풀이 참조
        연속된 A의 개수 중요.
        만약 BBBAAAAAABA 순서라면 A 까지 갔다가 다시 뒤로 돌아가는게 이동 횟수가 적음.
        ref) https://hellodavid.tistory.com/4
    */
    public int solution(String name) {
        int answer = 0;
        
        int len = name.length();
        int min = len-1;

        for(int i=0; i<len; i++) {
            char ch= name.charAt(i);
            int mov = Math.min( (ch-'A'), ('Z'-ch+1) ); // Z는 A에서 +1 만큼 움직여야 하므로 1더해줌.

            answer+=mov;

            int nextIndex = i+1;

            while( nextIndex<len && name.charAt(nextIndex) == 'A' ) {
                nextIndex++;
            }
            min = Math.min(min, (i*2)+len-nextIndex);
        }

        return answer;
    }
}
