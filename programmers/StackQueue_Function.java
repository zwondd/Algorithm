/*
    2021-09-28
    [Programmers][StackQueue][Lv2] 기능개발

    - Math.ceil 로 반올림
*/
import java.util.*;

class StackQueue_Function {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();

        // 숫자 반올림 type 확인 
        // 정수/정수 일 경우 반올림 안됨. type casting 해줘야함.
        for( int i=0; i<speeds.length; i++ ) {
            queue.add( (int)Math.ceil( (100-progresses[i])/(float)speeds[i]) );
        }

        List<Integer> arr = new ArrayList<>();
        while( !queue.isEmpty() ) {
            int distribute = queue.poll();
            int count=1;
            
            while( !queue.isEmpty() && queue.peek() <= distribute ) {
                count++;
                queue.poll();
            }
            arr.add(count);
        }

        answer = new int[arr.size()];
        int idx = 0;
        for(Integer cnt : arr ) {
            answer[idx++] = cnt;
        }

        return answer;
    }

    /*
        다른 풀이
    */
    public int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }

    public static void main(String[] args) {
        StackQueue_Function sf = new StackQueue_Function();

        int[] pr = {93, 30, 55};
        int[] sp = {1,30,5};
        sf.solution(pr, sp);
    }
    
}


