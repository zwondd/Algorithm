package codepro;

import java.io.*;
import java.util.Arrays;

/*

5
10 789 456
16 CBA FED
10 -123 56
10 -3214 -987
10 -12345 0

359784
CAAE32
-6888
3172218
0


*/
class Calculator {
	
	public static void solve(String testCase) {
		char[] toChr="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		int B = Integer.parseInt(testCase.split(" ")[0]);
		char[] S = testCase.split(" ")[1].toCharArray();
		char[] D = testCase.split(" ")[2].toCharArray();
		System.out.println(" B : " + B);
		System.out.println(" S : " + String.valueOf(S) );
		System.out.println(" D : " + String.valueOf(D) );

		int mulArr[] = new int[S.length+D.length+1];
		Arrays.fill(mulArr, 0);

		int sPos=0;
		int dPos=0;
		int minus=1;

		if ( S[0]== '-' ) {
			minus*=(-1);
			sPos++;
		}
		if ( D[0]== '-' ) {
			minus*=(-1);
			dPos++;
		}
		if ( S[0]=='0' || D[0]=='0' ) {
			System.out.println(0);
			return;
		}

		for(int i=S.length-1; i>=sPos; i--) {
			for(int j=D.length-1; j>=dPos; j--) {
				// System.out.println(S[i]);
				// System.out.println(D[j]);

				mulArr[i+j]+= (S[i]-'0')*(D[j]-'0');
				// System.out.println( (i+j) + " : " + mulArr[i+j]);
			}
		}

		for(int i=mulArr.length-1; i>sPos+dPos; i--) {
			if ( mulArr[i]>=B ) {
				mulArr[i-1]+=mulArr[i]/B;
				mulArr[i]%=B;
			}
		}
		// System.out.println(" mulArr : " + Arrays.toString(mulArr) );

		int first = 0;
		if ( mulArr[sPos+dPos]>=B ) {
			first=mulArr[sPos+dPos]/B;
			mulArr[sPos+dPos]%=B;
		}

		String result="";
		if ( minus<0 ) result+="-";
		if ( first>0 ) result+=toChr[first];

		int pos=sPos+dPos;
		while(  pos<mulArr.length && toChr[mulArr[pos]] != 0 ) {
			result+= toChr[mulArr[pos++]];
		}
		// for(int i=sPos+dPos; i<mulArr.length; i++) {
		// 	result+= toChr[mulArr[i]];
		// }

		System.out.println(result);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		for(int i=0; i<Integer.parseInt(input); i++) {
            String testCase=br.readLine();
            solve(testCase);
        }
	}
}
