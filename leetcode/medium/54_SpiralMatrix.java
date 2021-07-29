import java.util.*;

// 21-07-29

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();

        int m = matrix.length;
        int n = matrix[0].length;
        boolean [][] visit = new boolean[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill( visit[i], false);
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int cx=0, cy=0;
        int pos = 0;

        while( list.size()< m*n ) {
            list.add( matrix[cx][cy] ); 
            visit[cx][cy] = true;

            int nx = cx+dx[pos];
            int ny = cy+dy[pos];

            int posCnt=0;

            while( nx<0 || nx>=m || ny<0 || ny>=n || visit[nx][ny] ) {
                if ( posCnt >=3 ) break;
                pos = (pos+1)%4;
                
                nx = cx+dx[pos];
                ny = cy+dy[pos];
                // System.out.println( " == " + nx + ", " + ny );

                posCnt++;
            }
            cx = nx; cy = ny;
            // System.out.println( cx + ", " + cy + "  / pos : " + pos );
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(s.spiralOrder(matrix));
        System.out.println(s.spiralOrder(matrix2));
    }
}
