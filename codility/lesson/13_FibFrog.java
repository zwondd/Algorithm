/**
 * 21-03-03
 * 13_FibonacciNumbers_FibFrog
 */
package codility.lesson;

import java.util.*;

class FibFrog {
    // Other Solution 
    // 참고) https://jackjeong.tistory.com/47

    final static Map<Integer, Integer> fiboMap=new HashMap<>();

    public int solution(int[] A) {
        int N=A.length;
        for(int i=0; fibo(i)<=N+1; i++)  fibo(i); 

        List<Integer> fiboList=new ArrayList<>(fiboMap.values());
        Collections.reverse(fiboList);

        Queue<Point> queue=new LinkedList<>();
        boolean[] check=new boolean[N+1];

        queue.add(new Point(-1,0)); // start

        while( !queue.isEmpty() ) {
            Point curPoint=queue.poll();

            for(int fibo: fiboList) {
                int next=curPoint.x + fibo;
                if ( next==N ) {
                    return curPoint.y+1;
                } else if ( next<N && next>=0 ) {
                    if ( A[next]==1 && !check[next] ) {
                        check[next]=true;
                        Point point=new Point(next, curPoint.y+1);
                        queue.add(point);
                    }
                }
            }
        }
        return -1;
    }

    public int fibo(int num) {
        if ( num==0 ) return 0;
        if ( num==1 ) return 1;
        if ( fiboMap.containsKey(num) ) return fiboMap.get(num);
        fiboMap.put(num, fibo(num-1)+fibo(num-2));
        return fiboMap.get(num);
    }

    class Point {
        int x,y;

        public Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String [] args) {
        int[] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
        int[] t1 = {};
        int[] t2 = {0,0,0};
        int[] t3 = {1,1,1};



        FibFrog s = new FibFrog();
        int res = s.solution(A);
        System.out.println(res);

        System.out.println(s.solution(t1));
        System.out.println(s.solution(t2));
        System.out.println(s.solution(t3));



    }

    
}
