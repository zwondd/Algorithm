/**
 * 21-02-24 
 * 7_StacksAndQueues_StoneWall
 */ 
package codility.lesson.StackQueue;
import java.util.Stack;

class StoneWall {

    // My Solution 1 (100%) O(n) 
    // 다른 풀이 참고 
    // 문제 이해 오래 걸림.
    public int solution(int[] H) {
        Stack<Integer> addedH = new Stack<Integer>();
        int cnt=0;

        for(int i=0; i<H.length; i++) {
            while( !addedH.empty() && addedH.peek()>H[i] ) {
                addedH.pop();
            }

            if ( addedH.empty() || addedH.peek()<H[i] ) {
                addedH.push(H[i]);
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] height = {8,8,5,7,9,8,7,4,8};
        StoneWall s=new StoneWall();
        System.out.println(s.solution(height));
    }
    
}
