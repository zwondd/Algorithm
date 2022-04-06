package Heap;
/*
    2022-04-06
    [Programmers][Heap][Lv3] 이중우선순위큐
*/

import java.util.*;

class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minH = new PriorityQueue<>();

        for(int i=0; i<operations.length; i++) {
            String[] str = operations[i].split(" ");

            int num = Integer.parseInt(str[1]);
            if ( str[0].compareTo("I")==0 ) { // str1.equals(str2) 
                maxH.offer(num);
                minH.offer(num);
            } else if ( str[0].compareTo("D")==0 ) {
                if ( maxH.size()<=0 || minH.size()<=0 ) continue;

                if ( num==1 ) {
                    int maxVal = maxH.poll();
                    minH.remove(maxVal);
                } 

                if ( num==-1 ) {
                    int minVal = minH.poll();
                    maxH.remove(minVal);
                }
            }   
        }

        if ( maxH.size()<=0 || minH.size()<=0 ) {
            answer[0]=0;
            answer[1]=0;
        } else {
            answer[0]=maxH.peek();
            answer[1]=minH.peek();
        }
        return answer;
    }
    
}
