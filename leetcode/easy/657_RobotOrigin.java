/*
    2022-03-13
    [Leetcode][Easy] 657. Robot Return to Origin
*/
class RobotOrigin {
    /*
        Runtime: 838 ms, faster than 5.22% of Java online submissions for Robot Return to Origin.
        Memory Usage: 67.5 MB, less than 6.34% of Java online submissions for Robot Return to Origin.
    */
    public boolean judgeCircle(String moves) {
        char[] movArr = moves.toCharArray();

        // int[] dx = {-1, 0, 1, 0};
        // int[] dy = {0, 1, 0, -1};
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int curX, curY;
        curX=curY=0;

        for(int i=0; i<movArr.length; i++) {
            char curMove = movArr[i];
            int dirIdx = 0;

            if ( curMove == 'U' ) dirIdx = 0;
            if ( curMove == 'R' ) dirIdx = 1;
            if ( curMove == 'D' ) dirIdx = 2;
            if ( curMove == 'L' ) dirIdx = 3;

            curX += dx[dirIdx];
            curY += dy[dirIdx];
            // System.out.println( curX+ " " + curY);
        }

        if ( curX == 0 && curY == 0 ) return true;
        return false;
    }
}
