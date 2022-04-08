package DP;

import java.util.Arrays;

/*
    2022-04-08
    [Programmers][Heap][Lv3] 등굣길
*/
class School {
    /*
        puddle x, y 좌표 바꿔주니 성공
    */
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] way = new int[n+1][m+1];

        // for(int i=0; i<n; i++)
        //     Arrays.fill(way[i], 1);
        way[1][1]=1;

        // puddle x, y 좌표 바꿔주는 것 주의해야함.
        for(int i=0; i<puddles.length; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];

            way[x][y] = -1;
        }

        // for(int i=0; i<=n; i++)
        //     System.out.println(Arrays.toString(way[i]));

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                // System.out.println("i : " + i + " / j : " + j + " / " + way[i][j]);
                if ( way[i][j]==-1 ) continue;
                if ( i+1<= n && way[i+1][j]!=-1 ) way[i+1][j] += way[i][j] ;
                if ( j+1<= m && way[i][j+1]!=-1 ) way[i][j+1] += way[i][j];
            }
        }

        // for(int i=0; i<=n; i++)
        //     System.out.println(Arrays.toString(way[i]));
            
        answer = way[n][m]%1000000007;
    
        return answer;
    }

    /*
        Other solution 참조 
        https://velog.io/@ajufresh/%EB%93%B1%EA%B5%A3%EA%B8%B8
    */
    public int solution1(int m, int n, int[][] puddles) {
        int[][] street = new int[n][m];
        // 웅덩이는 -1
        for (int[] puddle : puddles)
            street[puddle[1] - 1][puddle[0] - 1] = -1;

        street[0][0] = 1; // 시작점은 1로 저장

        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) {
      
              if(street[i][j] == -1) { // 웅덩이면 0으로 바꾸고 continue
                street[i][j] = 0;
                continue;
              }
      
              if(i != 0)
                street[i][j] += street[i - 1][j] % 1000000007; // 숫자가 이 값을 초과할 수 있기 때문에 계산 과정에서 나머지 구하기
      
              if(j != 0)
                street[i][j] += street[i][j - 1] % 1000000007; // 왼쪽
            }
        }
        return street[n - 1][m - 1] % 1000000007;
    }


    public static void main(String[] args) {
        School s = new School();
        int[][] puddles = {{2,2}};
        int ans = s.solution(4, 3, puddles);
        System.out.println(ans);
    }
}
