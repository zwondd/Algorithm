/*
    2021-04-19
    Baekjoon 3055 탈출
  
    한 개의 Queue에 water, dog를 모두 넣음. 
    선입선출 구조에 따라 water에 의해 map이 업데이트 된 이 후에 dog가 움직이게 됨.
    
    참고) https://limkydev.tistory.com/174
*/
package baekjoon;

import java.util.*;

public class boj_3055_Escape_sol_2 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int h = sc.nextInt(); //행의 갯수
        int w = sc.nextInt(); //열의 갯수
         
        sc.nextLine();
        sc.close();
         
        char[][] map = new char[h][w];
        int[][] count = new int[h][w];
         
        for(int i=0; i<h; i++){
            String str = sc.nextLine();
            for(int j=0; j<w; j++){
                map[i][j] = str.charAt(j);
            }
        }
         
        BFS(map, count, w, h);
 
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] =='D'){
                    if(count[i][j]==0) {
                        System.out.println("KAKTUS");
                        return;
                    }
                    System.out.print(count[i][j]);
                    return;
                }
            }
        }
 
    }
     
     
    static int[] directX = {0, -1, 0, 1};
    static int[] directY = {1, 0, -1, 0};
    private static void BFS(char[][] map, int[][] count, int w, int h) {
         
        Queue<MyPoint> q = new LinkedList<>();
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] == '*') q.add(new MyPoint(i, j, '*'));
            }
        }
         
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] == 'S') q.add(new MyPoint(i, j, 'S'));
            }
        }
         
        while(!q.isEmpty()){
     
            MyPoint p = q.poll();
            for(int i=0; i<4; i++){
                int mvX = p.x + directX[i];
                int mvY = p.y + directY[i];
             
         
                if(-1 < mvX && mvX < h && -1 < mvY && mvY < w){
 
                    if(p.c == 'S') {
                        if((map[mvX][mvY] == '.' || map[mvX][mvY] == 'D') && map[mvX][mvY] != 'X'  ){
                            count[mvX][mvY] = count[p.x][p.y] + 1;
                            if(map[mvX][mvY] == 'D') return;
                            map[mvX][mvY] = 'S';
                            q.add(new MyPoint(mvX, mvY, p.c));
                        }
                    }
 
                    if(p.c == '*'){
                        if(map[mvX][mvY] != 'D' && map[mvX][mvY] != '*' && map[mvX][mvY] != 'X'){
                            map[mvX][mvY] = '*';
                            q.add(new MyPoint(mvX, mvY, p.c));
                        }   
                    }
             
                }
            }   
        }
    }
    static class MyPoint{
        int x;
        int y;
        char c;
        public MyPoint(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
         
         
    }
 
}
