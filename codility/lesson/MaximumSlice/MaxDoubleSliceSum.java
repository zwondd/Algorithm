/**
 * 21-02-24
 * 9_MaximumSlice_MaxDoubleSliceSum
 */
package codility.lesson.MaximumSlice;

import java.util.Arrays;

public class MaxDoubleSliceSum {
    int[][] dp;
    int maxSum=-1;

    // My Solution 1 (23%) 
    // wrong answer, timeout error(O(N^3) 넘어가게됨..)
    public int getSum(int s, int e, int[] A) {
        if ( s==e ) return 0;
        if ( dp[s][e]!=-1 ) return dp[s][e];

        int sum=0;
        for(int i=s; i<=e; i++) {
            sum+=A[i];
        }
        return sum;
    }
    public int solution1(int[] A) {
        dp=new int[A.length+2][A.length+2];

        for(int i=0; i<A.length; i++)
            Arrays.fill(dp[i], -1);

        for(int x=1; x<A.length-3; x++) {
            for(int y=x+1; y<A.length-2; y++) {
                for(int z=y+1; z<A.length-1; z++) {
                    // System.out.println(x+" , "+y+" , "+z);
                    int tmp=getSum(x, y-1, A) + getSum(y+1, z, A);
                    maxSum=(tmp>maxSum)?tmp:maxSum;
                    // System.out.println(maxSum);
                }
            }
        }
      
        return maxSum;
    }

    // Other Solution 1 
    // 풀이 ) y 기준으로 
    // x를 +1 해가며 최대 sum 
    // z를 -1 해가며 최대 sum 
    // 각각 배열 구해놓은 후 y 값에 따른 x_sum, z_sum의 합의 최대값 구함.
    // 왼쪽부터, 오른쪽부터 구한 합 중 중간에 음수가 나오면 합을 0으로 맞춰주는 부분 중요!!
    // x or z 를 해당 자리로 설정 (즉, 해당 값을 더하지 않게 하면 )하면 되니깐. 
    //            [0] [1] [2] [3] [4] [5]
    //             1   2   3  50  -3   2 
    //                        50   0   2
    //               rightSum <=======
    //       left[i-1]  y[i]  right[i+1]
    //        1) y=2-> rightMax[3] =50 (z=4)
    //        2) y=3-> rightMax[4] = 0 (z=4)
    //        3) y=4-> rightMax[5] = 0 (z=5)     
    //
    // 참고) https://hwan-shell.tistory.com/124
    // https://app.codility.com/demo/results/trainingMHFJVQ-B2J/
    public int solution(int[] A) {
        int result=0;

        int[] leftSum=new int[A.length+1];
        int[] rightSum=new int[A.length+1];

        if ( A.length<4 ) return 0;

        for(int i=1; i<A.length-1; i++) {
            leftSum[i]=Math.max(leftSum[i-1]+A[i], 0);
        }
        for(int i=A.length-1; i>1; i--) {
            rightSum[i-1]=Math.max(rightSum[i]+A[i-1], 0);
        }

        for(int i=1; i<A.length-1; i++) {
            result=Math.max(leftSum[i-1]+rightSum[i+1], result);
        }

        return result;
    }
 
    
    public static void main(String[] args) {
        MaxDoubleSliceSum m=new MaxDoubleSliceSum();
        int[] test = {3,2,6,-1,4,5,-1,2};
        System.out.println(m.solution(test));
    }
}
