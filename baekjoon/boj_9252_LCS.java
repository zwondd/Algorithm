package bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;


public class boj_9252_LCS {
	static int len1, len2, dp[][];
	static String[] word = new String[2];
	static String[][] lcs = new String[1002][1002];
	
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		try {
			word[0] = in.readLine();
			word[1] = in.readLine();
			len1 = word[0].length();
			len2 = word[1].length();
			
			dp = new int[len1+1][len2+1];
			for(int i=0; i<=len1; i++) 
				Arrays.fill(lcs[i], "");
			
			calcLCS();
			
			out.write(dp[len1][len2] + "\n" + lcs[len1][len2]);
			out.close();
			in.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void calcLCS() {
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				if ( word[0].charAt(i-1) == word[1].charAt(j-1) ) {
					dp[i][j] = dp[i-1][j-1] + 1;
					lcs[i][j] += lcs[i-1][j-1] + word[0].charAt(i-1);
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					lcs[i][j] = ( lcs[i-1][j].length() > lcs[i][j-1].length() ) ? lcs[i-1][j] : lcs[i][j-1];
				}
			}
		}
		
	}

}
