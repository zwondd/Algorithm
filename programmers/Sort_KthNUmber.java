/*
    2021-09-28
    [Programmers][Sort][Lv1] K번째 수 

    - java : Array.copyOfRage 함수
*/

import java.util.*;

public class Sort_KthNUmber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int idx=0;
        for(int i=0; i<commands.length; i++) {
            int[] newArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(newArr);
            answer[idx++] = newArr[commands[i][2]-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Sort_KthNUmber sk = new Sort_KthNUmber();
        int[] array ={1, 5, 2, 6, 3, 7, 4};
        int[][] commands ={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        sk.solution(array, commands);
    }
}
