/*
    210314
    LG codepro - [19년도_3차] 계산기
 */
package codepro;

import java.io.*;
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
	char[] toChr="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	public int toNum (char ch) {
		int i=0;
		for(i=0; i<toChr.length; i++) {
			if ( toChr[i] == num ) {
				break;
			}
		}
		return i;
	}

	public void solve(String testCase) {
		int B = Integer.parseInt(testCase.split(" ")[0]);
		char[] S = testCase.split(" ")[1].toCharArray();
		char[] D = testCase.split(" ")[2].toCharArray();

		// Arrays.fill(mulArr, 0);
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
		
		// problem ) S, D 배열의 수들이 - 부호에 의해 자릿수가 안맞게 됨.
		// ex) -123 / 345 일 때 1과3은 같은 자릿수 이지만 배열을 재정렬하지 않고 
		//      계산하게 되면 1과 3은 각각 1번째, 0번째로 다른 자릿수로 인식하게 됨.
		int mulArr[] = new int[S.length-sPos+D.length-1];
		for(int i=S.length-1; i>=sPos; i--) {
			for(int j=D.length-1; j>=dPos; j--) {
				mulArr[i+j]+= (toNum(S[i]))*(toNum(D[j]));
			}
		}

		// for(int i=mulArr.length-1; i>sPos+dPos; i--) {
		for(int i=mulArr.length-1; i>0; i--) {
			if ( mulArr[i]>=B ) {
				mulArr[i-1]+=mulArr[i]/B;
				mulArr[i]%=B;
			}
		}

		int first = 0;
		// if ( mulArr[sPos+dPos]>=B ) {
		if ( mulArr[0]>=B ) {
			first=mulArr[0]/B;
			mulArr[0]%=B;
		}

		String result="";
		if ( minus<0 ) result+="-";
		if ( first>0 ) result+=toChr[first];

		// int pos=sPos+dPos;
		int pos=0;
		while(  pos<mulArr.length && mulArr[pos] != 0 ) {
			result+= toChr[mulArr[pos++]];
		}

		System.out.println(result);
	}
	
	public static void main(String[] args) throws Exception {
		Calculator c=new Calculator();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		for(int i=0; i<Integer.parseInt(input); i++) {
            String testCase=br.readLine();
            c.solve(testCase);
        }
	}
}
