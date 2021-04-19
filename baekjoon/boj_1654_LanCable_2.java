/*
    2021-04-19
    Baekjoon 1654 랜선자르기
    
    solve1) 37076 KB, 456ms
    solve2) 30352 KB, 472ms   (sorting 때 index값 잘 확인하기!!!)
*/
package baekjoon;
import java.util.*;

class LanCable2 {
    static int K;
    static int N;
    // static long len[];
    static int len[];

    static long maxLen=-1;

    void input2() {
        Scanner sc=new Scanner(System.in);
        K=sc.nextInt();
        N=sc.nextInt();
        // len=new long[N+1];
        len=new int[K]; 

        for(int i=0; i<K; i++) {
            len[i]=sc.nextInt();
        }
        sc.close();
    }
    int binarySearch(long s, long e) {
        int count=0;
        long mid=(s+e)/2;
        if ( s>e ) return -1;

        for(int i=0; i<K; i++) {
            count+=len[i]/mid;
        }   
        if ( count>=N ) {
            maxLen=Math.max(mid, maxLen);
            // maxLen = (mid>maxLen) ? mid:maxLen;
            return binarySearch(mid+1, e);
        } else {
            return binarySearch(s, mid-1);
        }
    }

    // public static long Bsearch(long left, long right) {
	// 	int cnt = 0;
	// 	long mid = (left + right) / 2;
	// 	if(left > right) return maxLen;
	// 	for (int i : len) {
	// 		cnt += i / mid;
	// 	}
	// 	if( cnt >= N) {
	// 		if(mid > maxLen) {
	// 			maxLen = mid;
	// 		}
	// 		return Bsearch(mid + 1, right);
	// 	} else {
	// 		return Bsearch(left, mid -1);
	// 	}
	// }

    void solve2() {
        // binary search 에서는 정렬 필수
        // Arrays.sort(len, 0, K-1); // 전체 길이 아닐 때 fromIdx, toIdx 설정해줘야함.
        Arrays.sort(len, 0, K); // toIdx : K***

        // for(int i=0; i<K; i++) System.out.println("-- : " + len[i]);
        System.out.println(len[K-1]);
        binarySearch(1, len[K-1]);
        // Bsearch(1,len[K-1]);
        System.out.println(maxLen);
    }



    public static void main (String args[]) {
        LanCable2 m=new LanCable2();

        // solution
        m.input2();
        m.solve2();
    }
}
