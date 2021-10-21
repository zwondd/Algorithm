package DevMatching;

import java.util.Arrays;

public class Problem1 {
    public String solution2(String[] registered_list, String new_id) {
        String answer = "";

        Arrays.sort(registered_list);

        // for(String s : registered_list) 
        //     System.out.println(s);

        int nStart = -1;
        for(int i=0; i<new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if ( ch>= '0' && ch<='9' ) {
                nStart = i;
                break;
            }
        }

        String S="";
        String N="";
        if ( nStart == -1 ) {
            nStart = new_id.length();
        } else {
            N = new_id.substring(nStart);
        }

        S = new_id.substring(0, nStart);

        for(int i=0; i<registered_list.length; i++) {
            System.out.println(registered_list[i] + " " + new_id);

            if( registered_list[i].equals(new_id)) {
                System.out.println( " equals "+ S + " " + N.equals(""));

                String N1 = ( N.equals("") ) ? "1" : (Integer.parseInt(N)+1)+"";
                N=N1;
                System.out.println( " N1 "+ N1 );

                new_id = S+N1;
            }
            // System.out.println(new_id);
        }
        answer = new_id;
        return answer;
    }

    /*
        solution 1
    */
    public String solution(String[] registered_list, String new_id) {
        String answer = searchId( registered_list, new_id );
        return answer;
    }
    private boolean exists(String[] registered_list, String new_id) {
        for(int i=0; i<registered_list.length; i++) {
            if ( registered_list[i].equals(new_id) ) {
                return true;
            }
        }
        return false;
    }
    private String searchId(String[] registered_list, String new_id) {
        if ( exists(registered_list, new_id) == false ) {
            return new_id;
        }

        int nStart = -1;
        for(int i=0; i<new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if ( ch>= '0' && ch<='9' ) {
                nStart = i;
                break;
            }
        }
        if ( nStart == -1 ) {
            new_id += '1';
        } else {
            
            String S = new_id.substring(0, nStart);
            String N = new_id.substring(nStart);
            String N1 = (Integer.parseInt(N)+1) + "";

            new_id = S+N1;
        }
        return searchId(registered_list, new_id);
    };
    public static void main(String[] args) {
        Problem1 p1 = new Problem1();
        // String[] str = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
        // String ni = "ace15";

        // String[] str = {"apple1", "orange", "banana3"};
        // String ni = "apple";

        String[] str = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
        String ni = "cow";

        System.out.println(p1.solution2(str, ni));
    }
}
