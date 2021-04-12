/*
   2021-04-12
   LG codepro - [19년도_1차] 장기자랑
   1/12 : success(11 timeout) (60min) 
 */
package codepro;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TalentShow {
    int N, S, M;
    int list[];
    int order[];
    int pos=0;

    void inputData() {
        Scanner sc = new Scanner(System.in);
        N     = sc.nextInt();
        S     = sc.nextInt();
        M     = sc.nextInt();
        
        list  = new int[N+2];
        order = new int[N+2];
        for(int i=0; i<N; i++ ){
            list[i] = i+1;
        }
        sc.close();;
    }

    public void solve() {
        int cnt=1;
        while(pos<N) {
            while(cnt<M) {
                S=(S+1)%N;
                if ( S==0 ) S=7;
                if ( list[S] == 1 ) {
                    continue;
                }
                cnt++;
            }
            // System.out.println("S : " + S + " list[S] : " + list[S]);
            
            list[S] = 1;
            order[pos++] = S;
            cnt=0;
        }

        for(int i=0; i<N; i++) {
            System.out.print(order[i] + " ");
        }

    }

    // solution 보고 재풀이 - Queue 사용해서
    public void solve2() {
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++) q.add(i);

        for(int i=1; i<S; i++) {
            int tmp = q.poll();
            q.add(tmp);
        }

        while(!q.isEmpty()) {
            for(int i=1; i<M; i++) {
                int tmp = q.poll();
                q.add(tmp);
            }
            int turn=q.poll();
            System.out.print(turn + " ");
        }
    }


    public static void main(String[] args) {
        TalentShow t=new TalentShow();
        t.inputData();
        // t.solve();
        t.solve2();

    }
    
}
