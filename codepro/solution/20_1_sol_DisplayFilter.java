package codepro.solution;

import java.util.Scanner;

class DisplayFilter {
    int N;//필터의 수
	int R[]=new int [11]; //반사의 정도
	int P[]=new int [11]; //투과의 정도
	static int sol = 0x7FFFFFFF;
	static int diff = 0x7FFFFFFF;
	void InputData(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			R[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		sc.close();
	}

	void Dfs(int n, int r, int p, int cnt){
		int val = Math.abs(r - p);
		if (n > N) {
			if (cnt == 0) return;
			if (val < diff)
			{
				diff = val;
				sol = cnt;
			}
			else if (diff == val)
			{
				if (sol>cnt) sol = cnt;
			}
			return;
		}
		Dfs(n+1, r*R[n], p+P[n], cnt+1);
		Dfs(n+1, r, p, cnt);
	}

    long mindiff= 1000000;
    long mincnt=0;
    void Dfs2(int s, int cnt, long mul, long sum){
		if ( cnt!=0 ) {
            long diff = Math.abs(mul-sum);

            if ( (mindiff > diff) || ((mindiff==diff) && (mincnt>cnt)) ) {
                mindiff = diff;
                mincnt = cnt;
            }
        }

        for(int i=s; i<=N; i++) {
            Dfs2(i+1, cnt+1, mul*R[i], sum+P[i]);
        }
	}
    // Dfs2(1,0,1,0);

	public static void main(String[] args){
		// Main m = new Main();
        DisplayFilter m=new DisplayFilter();

		m.InputData();	 //	입력 함수

        // solution 1)
		// m.Dfs(1,1,0,0);
		// System.out.println(m.N-sol);

        // solution 2)
        m.Dfs2(1,0,1,0);
        System.out.println(m.N-m.mincnt);
	}
    
}
