/*
    2021-08-24
    [Leetcode][Medium] 97. Interleaving String

    solution by dp
    dp[i][j] = i characters before S1, j characters before S2 can be spliced into S3(i+j) characters

*/

class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if ( s1.length() + s2.length() != s3.length() ) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();

        boolean[][] isValid = new boolean[c1.length+1][c2.length+1];

        isValid[0][0] = true;

        for(int i=1; i<c1.length; i++ ) isValid[i][0] = isValid[i-1][0] && c1[i-1] == c3[i-1];
        for(int i=1; i<c2.length; i++ ) isValid[0][i] = isValid[0][i-1] && c2[i-1] == c3[i-1];

        for( int i=1; i<=c1.length; i++ ) {
            for(int j=1; j<=c2.length; j++) {
                isValid[i][j] = ( isValid[i-1][j] && c1[i-1]==c3[i+j-1] ) || ( isValid[i][j-1] && c2[j-1]==c3[i+j-1]);
            }
        }
        return isValid[c1.length][c2.length];
    }

    // wrong
    public boolean isInterleave2(String s1, String s2, String s3) {
        int[] temp = new int[s1.length()];

        int k=0;
        for(int i=0; i<s1.length(); i++) {
            for(int j=0; j<s3.length(); j++) {
                if ( s1.charAt(i) != s3.charAt(j) ) {
                    temp[k++] = j;
                    break;
                }
            }
        }
        for(int i=0; i<temp.length; i++) {
            System.out.print( s3.charAt(temp[i]));
        }
        System.out.println();
        if ( k!=s1.length() ) {
            return false;
        }

        k=0;
        for(int i=0; i<temp.length; i++, k++) {
            if ( s2.charAt(k) != s3.charAt(temp[k]) ) {
                return false;
            }
        }
        return true;
     }
 
     // wrong
    public boolean isInterleave1(String s1, String s2, String s3) {
       char[] temp = new char[s2.length()];


       int p1, p2, p3;
       p1=p2=p3=0;
       while( p1 < s1.length() && p3 < s3.length() ) {
            System.out.print( "s1 : " + s1.charAt(p1) + "  s3 : " + s3.charAt(p3) );
            if ( s1.charAt(p1) == s3.charAt(p3) ) {
                p1++; p3++;
            } else {
                temp[p2] = s3.charAt(p3);
                p2++; p3++;
            }
            System.out.println();
        }
       

        if ( p1 < s1.length() ) {
            return false;
        }

        for( ; p3<s3.length(); p3++, p2++) {
            temp[p2] = s3.charAt(p3);
        }

        for(int i=0; i<temp.length; i++) {
            System.out.print(temp[i]);
        }
        System.out.println();

        p2=0;
        while( p2 < s2.length() ) {
            if ( s2.charAt(p2) != temp[p2] ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        InterleavingString il = new InterleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println( il.isInterleave(s1, s2, s3) );
    }
}
