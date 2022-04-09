package BinarySearch;

import java.util.Arrays;

/*
    2022-04-08
    [Programmers][BinarySearch][Lv3] 입국심사
*/
public class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start=times[0]*n;
        long end = (long)times[times.length-1]*n; // (long) 변환 안해주면 에러남

        while( start<=end ) {
            long mid = (start+end)/2;
            long done=0;

            for(int i=0; i<times.length; i++) {
                done+= mid/times[i];
            }

            if (done<n) {
                start=mid+1;
            } else { // 해야할 인원보다 심사처리 많이함 -> 시간 줄여서 더 최고의 경우 만듬.
                end=mid-1;
                answer=mid;
            }
        }
        return answer;
    }
}
