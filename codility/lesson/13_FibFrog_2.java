/**
 * 21-06-06
 * 13_FibonacciNumbers_FibFrog
 * 
 * Resolution1) 41%
 * https://app.codility.com/demo/results/training3993V9-FQZ/
 * 
 * Resolution 2) 83%
 * check 배열로 한번 방문한 A 위치에 대해선 다시 방문 X
 * https://app.codility.com/demo/results/trainingM5MER4-FQ5/
 * 
 */
package codility.lesson;

import java.util.*;

class FiboFrog2 {
    int N;
    List<Integer> fibo = new ArrayList<>();
    Queue<Pos> q= new LinkedList<Pos>();

    class Pos{
        int cur;
        int step;

        Pos (int x, int y) {
            this.cur = x;
            this.step = y;
        }
    }

    public void getFibonacci( int cur, int max ) {
        if ( fibo.get(cur-1) > max ) return;

        int tmp = fibo.get(cur-1) + fibo.get(cur-2);
        fibo.add(tmp);
        getFibonacci(cur+1, max);
    };

    public int solution(int[] A) {
        N = A.length;
        boolean[] check=new boolean[N+1];

        fibo.add(0);
        fibo.add(1);
        if ( N>=2 ) {
            getFibonacci(2, N+1);
        }
        Collections.reverse(fibo);

        q.add(new Pos(-1,0));
        
        while( !q.isEmpty() ) {
            Pos pos = q.poll();
            for(int fiboNum : fibo ) {
                int next = pos.cur + fiboNum;
                // System.out.println(" i : " + i + " fiboNum : " + fiboNum);

                if ( next == N ) {
                    return (pos.step+1);
                } else if ( next<N && next>=0 ) {
                    if ( A[next]==1 && !check[next] ) {
                        check[next] = true;
                        q.add( new Pos(next, pos.step+1) );
                        
                    }
                }
            }
            // for( int i=0; i<fibo.size()-1; i++) {

            //     int fiboNum = fibo.get(i);
            //     int next = pos.cur + fiboNum;
            //     // System.out.println(" i : " + i + " fiboNum : " + fiboNum);

            //     if ( next == N ) {
            //         return (pos.step+1);
            //     } else if ( next<N && next>=0 ) {
            //         if ( A[next]==1 && !check[next] ) {
            //             check[next] = true;
            //             q.add( new Pos(next, pos.step+1) );
                        
            //         }
            //     }
            // }
        }
        return -1;
    }


    public static void main(String [] args) {
        int[] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
        int[] t1 = {};
        int[] t2 = {0,0,0};
        int[] t3 = {1,1,1};



        FiboFrog2 s = new FiboFrog2();
        int res = s.solution(A);
        System.out.println(res);

        System.out.println(s.solution(t1));
        System.out.println(s.solution(t2));
        System.out.println(s.solution(t3));



    }
}
