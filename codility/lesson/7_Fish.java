/**
 * 21-02-23
 * 7_StacksAndQueues_Fish
 */ 

package codility.lesson.StackQueue;

import java.util.*;

class Fish {
    // My Solution 1 36min (37%) 
    // wrong answer, timeout error
    // 아예 문제 이해를 잘 못 하고 품
    public int solution1(int[] A, int[] B) {
        List<Integer> upstream = new ArrayList<Integer>();
        List<Integer> downstream = new ArrayList<Integer>();

        for(int i=0; i<A.length; i++) {
            if ( B[i]==0 ) {
                upstream.add(A[i]);
            } else {
                downstream.add(A[i]);
            }
        }

        Collections.sort(upstream);
        Collections.sort(downstream);

        while( !upstream.isEmpty() && !downstream.isEmpty() ) {
            int uTemp=upstream.get(0); upstream.remove(0);
            int dTemp=downstream.get(0); downstream.remove(0);

            if ( uTemp>dTemp ) {
                upstream.add(0, uTemp);
            } else {
                downstream.add(0, dTemp);
            }
        }
        // System.out.println(downstream.size() + " \\ " + upstream.size());
        if ( upstream.isEmpty() ) {
            return downstream.size();
        } else {
            return upstream.size();
        }
    }

    // My Solution 2 (100%) O(n) 
    // 다른 풀이 참고 
    public int solution(int[] A, int[] B) {
        Stack<Integer> downStream=new Stack<Integer>();

        int alive=0;
        for(int i=0; i<A.length; i++) {
            if ( B[i]==0 ) {
                if ( downStream.empty() ) {
                    alive++;
                } else {
                    while( !downStream.empty() && downStream.peek() < A[i] ) {
                        downStream.pop();
                    }
                    if ( downStream.empty() ) {
                        alive++;
                    }
                }
            } else {
                downStream.push(A[i]);
            }
        }
        return alive+downStream.size();
    }
    public static void main(String[] args) {
        Fish f=new Fish();

        int[] A1 = {4,3,2,1,5};
        int[] B1 = {0,1,0,0,0};

        System.out.println(f.solution(A1, B1));
    }
    
}
