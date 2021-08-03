// 21-08-03

package leetcode.easy;

class LongestPalindrome {

    // My Solution
    public int longestPalindrome(String s) {
        int[] cnt = new int[58];
        String[] arr = s.split("");

        for( String str : arr ) {
            cnt[(int)str.toCharArray()[0]-'A']++;
        }

        int sum = 0;
        // int maxOdd = 0;
        boolean oddExists = false;

        for( int i : cnt ) {
            // System.out.println( i );
            if ( i%2 == 0 ) {
                sum+=i;
            } else {
                oddExists = true;
                sum = sum + i -1;
                // maxOdd = ( maxOdd < i ) ? i : maxOdd;
            }
        }
        if ( oddExists ) sum+=1;
        return sum;
    }

    public int longestPalindrome2(String s) {
        int[] count = new int[Math.abs('A'-'z')+1];
        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i)-'A']++;
        }
        for(int n: count) {
            ans+=n/2;
        }
        return Math.min(ans*2+1, s.length());
    }

    public static void main(String[] args) {
        // System.out.println((int)'a'-'A');
        // System.out.println((int)'z'-'A');
        // System.out.println((int)'A'-'A');
        // System.out.println((int)'Z'-'A');
        LongestPalindrome l = new LongestPalindrome();
        String s= "bb";
        System.out.println(l.longestPalindrome(s));

        String s2 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(l.longestPalindrome(s2));


    }
}
