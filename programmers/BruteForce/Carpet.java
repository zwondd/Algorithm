/*
    2021-10-14
    [Programmers][BruteForce][Lv2] 카펫
*/
package BruteForce;

public class Carpet {
    public int[] solutionMy(int brown, int yellow) {
        int[] answer = new int[2];
        
        int x=0, y=0;

        int k=yellow;

        while( k >= yellow/k ) {
            // System.out.println(" k : " + k );
            if ( yellow % k != 0 ) {
                k--;
                continue;
            }

            if ( (k+2)*(yellow/k+2) == brown+yellow ) {
                x = k+2;
                y = yellow/k + 2;
                break;
            }
            k--;
        }

        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }

    public int[] solution(int brown, int red) {
        int a = (brown+4)/2;
        int b = red+2*a-4;
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
    }
    public int[] solution2(int brown, int red) {
        for(int i=1; i<=red; i++) {
            if(red%i==0 && (red/i+i)*2+4==brown) {
                return new int[] {red/i+2, i+2};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Carpet cp = new Carpet();
        cp.solution(10, 2);
    }
    
}
