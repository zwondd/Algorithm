/**
 * 21-02-25
 * 9_MaximumSlice_MaxProfit
 */
package codility.lesson.MaximumSlice;

public class MaxProfit {
    // My Solution 1 (66%) O(N**2)
    // timeout error
    public int solution1(int[] A) {
        int ans=0;

        for(int i=0; i<A.length; i++) {
            for(int j=i+1; j<A.length; j++) {
                if ( A[j]<A[i] ) continue;

                ans=Math.max(ans, A[j]-A[i]);
            }
        }
        return ans;
    }

    // My Solution 2 15min (55%) 
    // wrong answer, runtime error
    public int solution2(int[] A) {
        int left=0; 
        int right=A.length-1;

        int leftMin=left;
        int rightMax=right;

        if ( A.length<1 ) return 0; // fix

        while(left<right) {
            if ( A[leftMin]>A[left] ) {
                leftMin=left;
            }
            
            if ( A[rightMax]<A[right]) {
                rightMax=right;
            }

            left++;
            right--;
        }

        if ( A[rightMax]-A[leftMin]<0 ) return 0;

        return A[rightMax]-A[leftMin];
    }

    // My Solution 3 (100%) O(N)
    // https://app.codility.com/demo/results/trainingBWUEN2-CY9/
    public int solution(int[] A) {
        if ( A.length<1 ) return 0;
        
        int[] leftMin=new int[A.length+1];
        int[] rightMax=new int[A.length+1];

        leftMin[0]=A[0];
        rightMax[A.length-1]=A[A.length-1];

        for(int i=1; i<A.length; i++) {
            leftMin[i] = Math.min( leftMin[i-1], A[i]);
        }
        for(int i=A.length-2; i>=0; i--) {
            rightMax[i] = Math.max( rightMax[i+1], A[i]);
        }


        int ans=0;
        for(int i=0; i<A.length; i++) {
            ans=Math.max(ans, rightMax[i]-leftMin[i]);
            // System.out.println(rightMax[i] + " " + leftMin[i]);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        MaxProfit m=new MaxProfit();

        int[] A=new int[6];
        A[0] = 23171;
        A[1] = 21011;
        A[2] = 21123;
        A[3] = 21366;
        A[4] = 21013;
        A[5] = 21367;
        System.out.println(m.solution(A));

        int [] test1={};
        System.out.println(m.solution(test1));

        int [] test2={4,3,2,1,2,3,4};
        System.out.println(m.solution(test2));

        int [] test3={1,2,3,4,10,20,30,40};
        System.out.println(m.solution(test3));
        
        int[] test4={1};
        System.out.println(m.solution(test4));


    }
    

}
