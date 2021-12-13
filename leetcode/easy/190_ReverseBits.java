/*
    2021-08-31
    [Leetcode][Easy] 190. Reverse Bits
*/
class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        int mask = 1;
        for(int i=0; i<32; i++) {
            int digit = n&mask;
            if ( digit!=0 ) {
                result += 1;
            }
            mask = mask<<1;
        }
        return result;
    }
    /*
        ref ) https://sowon-dev.github.io/2021/01/21/210122al-l0190/
        Runtime: 1 ms, faster than 97.95% of Java online submissions for Reverse Bits.
        Memory Usage: 38.9 MB, less than 37.38% of Java online submissions for Reverse Bits.    
    */
    public int reverseBits2(int n) {
        int ans = 0;
        for(int i=0; i<32; i++) {
            ans = ans<<1;
            if ( (n&1) > 0 ) {
                ans = ans|1;
            }
            n=n>>1;
        }
        return ans;
    }
   
    // Runtime error
    public int reverseBits1(int n) {
        char[] arr = Integer.toBinaryString(n).toCharArray();
        char[] arr2 = new char[32];
        int i;
        for(i=arr.length-1; i>=0; i--) {
            arr2[arr.length-1-i] = arr[i];
        }
        if ( arr.length<32 ) {
            for(i=arr.length; i<=31; i++) {
                arr2[i]='0';
            }
        }
        return Integer.parseInt(String.valueOf(arr2), 2);
    }

    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();
        String n = "00000010100101000001111010011100";
        System.out.println(r.reverseBits(Integer.parseInt(n, 2)));
    }
}
