package Heap;
/*
    2022-04-05
    [Programmers][Heap][Lv3] 디스크 컨트롤러
*/

import java.util.*;

class DiskController {
    /*
        SJF 스케줄링 (Shortest Job First)
    */
    public int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; // 수행되고난 직후 시간
        int jobsIdx=0; // jobs 배열 인덱스
        int count=0; // 수행된 요청 갯수

        // 요청시간 오름차순
        Arrays.sort(jobs, (o1,o2)->o1[0]-o2[0]);

        // 처리시간 오름차순 정렬 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);

        while( count<jobs.length ) {
            // 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
            while( jobsIdx<jobs.length && jobs[jobsIdx][0]<=end ) {
                pq.add(jobs[jobsIdx++]);
            }

            if( pq.isEmpty() ) {
                end = jobs[jobsIdx][0];
            } else {
                int[] temp = pq.poll();
                answer+=temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }
        
        return (int) Math.floor(answer / jobs.length);
    }
    
}
