package Heap;

/*
    2022-04-05
    [Programmers][Heap][Lv2] 더 맵게
*/

import java.util.*;

public class Spicy {
    public int solution(int[] scoville, int K) {
        Queue<Integer> minHeap = new PriorityQueue<>(); // 오름차순?

        for(int i=0; i<scoville.length; i++) minHeap.add(scoville[i]);

        int answer=0;
        while( minHeap.peek()<K ) {  // 부모 노드 값이 K이하인지를 while 문 조건으로 넣어줘야함.
            if ( minHeap.size()<2 ) return -1;
            int first = minHeap.poll();
            int second = minHeap.poll();
            int mixed = first + second*2;
            minHeap.add(mixed);
            answer++;
        }
        return answer;


        // fail case 존재

        // int mixCnt=0;
        // while( minHeap.size()>1 ) {
        //     if ( minHeap.peek()>=K ) return mixCnt;

        //     int first = minHeap.poll();
        //     int second = minHeap.poll();
        //     int mixed = first + second*2;
        //     minHeap.add(mixed);
        //     mixCnt++;
        // }
        
        // if( minHeap.size()==1 && minHeap.peek()>=K ) return mixCnt;
        // return -1;
    }
}
