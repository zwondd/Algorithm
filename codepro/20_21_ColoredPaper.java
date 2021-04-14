/*
   2021-04-14
   LG codepro - [20or21년도] 색종이
   12/12 : success (57min)
 */
package codepro;

import java.util.Scanner;

class ColoredPaper {

    int N;//도화지 크기
	char A[][] = new char[10 + 2][10 + 2];//도화지 색정보

	void InputData(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) A[i] = sc.next().toCharArray();
		sc.close();
	}

	public static void main(String[] args){
		int ans = -1;
		// Main m = new Main();
		ColoredPaper m = new ColoredPaper();

		m.InputData();				//	입력 함수

        int check[][] = new int[10+2][10+2];
        
        for(int i=1; i<=9; i++) {
            char conv=(char) (i + '0');
            int minX=100, maxX=-1, minY=100, maxY=-1;
            
            for(int x=0; x<m.N; x++) {
                for(int y=0; y<m.N; y++) {
                    
                    if ( m.A[x][y] == conv ) {
                        // System.out.println( m.A[x][y] + " : " +  conv );

                        if ( minX > x ) minX = x;
                        if ( maxX < x ) maxX = x;

                        if ( minY > y ) minY = y;
                        if ( maxY < y ) maxY = y;
                    }
    
                }
            }
            // System.out.println( minX + " " + maxX + " " + minY + " " + maxY );

            if ( minX<0 || minY<0 || maxX>m.N || maxY>m.N ) continue;

            for(int a=minX; a<=maxX; a++) {
                for(int b=minY; b<=maxY; b++) {
                    check[a][b]++;
                }
            }
            // System.out.println("*******");
            // for(int ii=0; ii<m.N; ii++) {
            //     for(int j=0; j<m.N; j++) {
            //         System.out.print(check[ii][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println("*******");

        }

        // for(int i=0; i<m.N; i++) {
        //     ans = Collections.max(Arrays.asList(check[i]));
        // }
        // System.out.println("==================");
        // for(int i=0; i<m.N; i++) {
        //     for(int j=0; j<m.N; j++) {
        //         System.out.print(check[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("==================");

        for(int i=0; i<m.N; i++) {
            for(int j=0; j<m.N; j++) {
                if ( ans<check[i][j] ) ans=check[i][j];
            }
        }


		System.out.println(ans);//출력
	}

    
}
