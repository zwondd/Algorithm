import java.util.HashMap;

public class Problem2 {
    public int solution(int leave, String day, int[] holidays) {
        int answer = -1, startSAT=-1, startSUN=-1;        

        int[] dayOff = new int[30+1];
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

        for(int i=0; i<days.length; i++) {
            if ( days[i].equals(day) )  {
                int check=1;
                for(int j=i; j<=i+6; j++) {
                    if ( days[j%7].equals("SAT") ) startSAT=check;
                    if ( days[j%7].equals("SUN") ) startSUN=check;
                    check++;
                }
            }
        }

        // holiday dayOff
        for(int i=0; i<holidays.length; i++) {
            dayOff[holidays[i]] = 1;
        }
        System.out.println(startSAT + " " + startSUN );
        // weekend dayOff
        while( startSAT<=30 ) {
            dayOff[startSAT]=1; startSAT+=7;
        }
        while( startSUN<=30 ) {
            dayOff[startSUN]=1; startSUN+=7;
        }

        

        for(int i=1; i<=30; i++) {
            System.out.print(dayOff[i] + " ");
            if ( i%7==0 ) System.out.println();
        }

        int[][] offCnt = new int[31][31];

        // dp
        // for(int i=2; i<=30; i++) {
        //     if ( dayOff[i] == 0 ) continue;
        //     dayOff[i] += dayOff[i-1];
        // }
        for(int i=1; i<=30; i++) {
            System.out.print(dayOff[i] + " ");
        }

        int maxLeave = -1;
        for(int i=30; i>=1; i--) {
            int chk = leave;
            int tmpMaxLeave = 0;

            System.out.println("i : " + i);

            for(int j=i; j>=1; j--) {
                if ( chk==0 && dayOff[j]==0 ) {
                    // maxLeave = Math.max(maxLeave, tmpMaxLeave);
                    break;
                }

                if ( dayOff[j]==0 ) {
                    chk--;
                    tmpMaxLeave++;
                } else {
                    tmpMaxLeave+=dayOff[j];
                }
            }
            System.out.println("maxLeave : " + maxLeave + " tmpMaxLeave : " + tmpMaxLeave);
            maxLeave = Math.max(maxLeave, tmpMaxLeave);

        }
        System.out.println();
        System.out.print(" -- maxLeave : " + maxLeave + " ");
        return maxLeave;
    }
    public static void main(String[] args) {
        Problem2 p2 = new Problem2();
        // int leave = 4;
        // String day = "FRI";

        int leave = 3;
        String day = "SUN";

        int[] holidays = {2, 6, 17, 29};

        System.out.println(p2.solution(leave, day, holidays));
    }
}
