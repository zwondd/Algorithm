/*
    2021-10-21
    [Programmers][DfsBfs][Lv2] 단어변환
*/
package DfsBfs;

public class TargetNumber {
    int cnt=0;

    /*
        My Solution
    */
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return cnt;
    }


    private void dfs( int idx, int sum, int[] numbers, int target) {
        if ( idx >= numbers.length ) {
            if ( sum == target ) {
                cnt++;
            }
            return;
        }

        dfs( idx+1, sum+numbers[idx], numbers, target );
        dfs( idx+1, sum-numbers[idx], numbers, target );
    }

    /*
        Other Solution
    */
    public int solution2(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
    
}
