package DP;

/*
    2022-04-08
    [Programmers][DP][Lv4] 도둑질
*/
class Thief {
    /*
        첫 번째 집을 터는것과,
        첫 번째 집을 안터는 것 dp 배열 나누어서 생각해야함.
    */
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length-1;
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];

        dp1[0]=money[0]; 
        dp1[1]=dp1[0];

        dp2[0]=0; 
        dp2[1]=money[1];

        for(int i=2; i<n; i++) {
            dp1[i] = Math.max(dp1[i-2]+money[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2]+money[i], dp2[i-1]);
        }
        dp2[n]=Math.max(dp2[n-2]+money[n], dp2[n-1]);
        answer = Math.max(dp1[n-1], dp2[n]);

        return answer;
    }

    public int solution1(int[] money) {        
        int[][] pick = new int[2][money.length];

        pick[0][0] = money[0];
        pick[0][1] = money[0];
        pick[1][0] = 0;
        pick[1][1] = money[1];

        for(int i=2; i<money.length; i++) {
            pick[0][i] = Math.max(pick[0][i-2] + money[i], pick[0][i-1]);
            pick[1][i] = Math.max(pick[1][i-2] + money[i], pick[1][i-1]);
        }

        return Math.max(pick[0][pick[0].length-2], pick[1][pick[1].length-1]);
    }
}
