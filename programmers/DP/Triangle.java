package DP;

import java.util.Arrays;

/*
    2022-04-08
    [Programmers][Heap][Lv3] 정수 삼각형
*/
class Triangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                if ( j==0 ) {
                    triangle[i][j] += triangle[i-1][j];
                } else if ( j==triangle[i].length-1 ) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
                System.out.println(triangle[i][j]);
            }
        }
        int size = triangle.length;
        for(int i=0; i<size; i++) {
            answer = Math.max(answer, triangle[size-1][i]);
        }
        return answer;
    }

    /*
        Other Solution
    */
    public int solution2(int[][] triangle) {
        for(int i=1; i<triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for(int j=1; j<i; j++) {
                triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
            }
        }
        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        t.solution(triangle);
    }
}
