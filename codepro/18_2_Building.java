/*
   2021-04-16
   LG codepro - [18년도_2차] 건물옥상정원
   4/10 : success (88min)

   항상 Data Type 확인!!! int, long ...
 */
package codepro;

import java.io.*;
import java.util.*;

// class Main {
class Building{
	int N;
	int h[];
	
	public long solve() {     //  return type int -> long으로 바꿨더니 10/10 success
		long sum[]  = new long[N];
		Stack<Integer> st = new Stack<>();
		
		st.push(N-1);
		for(int i=N-2; i>=0; i--) {
			if ( h[i] > h[i+1] ) {
                while ( !st.empty() ) {
                    int top = st.peek();
                    // if ( h[top] > h[i] ) break;  // (1)
                    if ( h[top] >= h[i] ) break;   // (2)  ;  (1) -> (2)  변경 시 8/10 success
                    
                    sum[i] += sum[top]+1;						
                    st.pop();
                } 
                st.push(i);
			} else {
				sum[i] = 0;
				st.push(i);
			}
			// System.out.println(" i : " + i + " sum : " + sum[i] );
		}
		
		long total=0;
		for(int i=0; i<N; i++) {
			total+=sum[i];
		}
		return total;
	}
	
	public static void main(String[] args) throws Exception {
		// Main m=new Main();
        Building m = new Building();
		
		Scanner sc = new Scanner(System.in);
		m.N = sc.nextInt();
		m.h = new int[m.N];
		
		for(int i=0; i<m.N; i++) {
			m.h[i] = sc.nextInt();
		}
        sc.close();
		
		long ans = m.solve();
		System.out.println(ans);
	}
}