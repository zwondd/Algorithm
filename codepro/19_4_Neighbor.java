/*
   2021-04-11
   LG codepro - [19년도_4차] 불우이웃돕기
    3/12 : success (45min)
    

    solution 보고 재수정 후 
    12/12 : success 전체 통과함

 */
package codepro;

import java.util.Scanner;

class Neighbor {
    int N;
    int[] kind={1, 5, 10, 50, 100, 500, 1000, 3000, 6000, 12000};
    int[] box  = new int[10];
    int[] send = new int[10];

    public void Input() {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        for(int i=0; i<10; i++) {
            box[i]=sc.nextInt();
        }
        sc.close();
    }

    public void solve() {
        int i;
        int sumAll=0, remain=0, cnt=0;
        for(i=0; i<10; i++) {
            // if ( sumAll>N ) break;
            if ( sumAll>=N ) break;

            sumAll+=(box[i]*kind[i]);
        }
        // System.out.println(" sumAll : " + sumAll);
        remain = sumAll-N;
        // System.out.println(" remain : " + remain + " i : " + i);

        for(int j=i-1; j>=0; j--) { 
            // if ( remain<kind[j] ) continue;            // problem) 이 부분 제거, 즉 i이하 는 전체 send[j] 개수 구해주도록 하면 전체 TC 통과됨!!!

            // kind별 box 개수 확인하여도 TC 통과 다 안되는지 확인
            int temp = remain/kind[j];
            if ( temp>box[j] ) temp=box[j];

            remain-= kind[j]*temp;
            send[j] = box[j]-temp;
            cnt+=send[j];

            // send[j]=box[j]-remain/kind[j];     // problem) box[j] 개수가 remain/kind[j] 보다 적을 수 있음. 이를 고려해서 send[j] 개수를 정해야함
            // remain%=kind[j];
            // cnt+=send[j];
        }
        System.out.println(cnt);
        for(i=0; i<10; i++) 
            System.out.print(send[i] + " ");
    }

    public static void main(String[] args) throws Exception {
        Neighbor nb=new Neighbor();
        nb.Input();
        nb.solve();
    }
    
}

/*
267
15 6 6 3 2 2 2 2 2 1

5
5 1 0 0 0 0 0 0 0 0
-> 통과됨

26
10 2 2 0 0 0 0 0 0 0
-> 통과됨

=> N 과 box 개수의 합이 정확히 일치 될 때 까지의 kind[i] 까지만 계산하면
remain = 0이 되어 버리므로 kind[9] 까지 전체 합을 구한 후 빼줘야함.
*/
