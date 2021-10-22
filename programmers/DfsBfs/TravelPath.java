/*
    2021-10-22
    [Programmers][DfsBfs][Lv3] 여행경로
*/
package DfsBfs;

import java.util.*;

public class TravelPath {
    /*
        Solution 1
        출처 ) https://moonsbeen.tistory.com/149?category=1184370
    */
    boolean[] visit;
    ArrayList<String> answers;

    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        answers = new ArrayList<>();

        int count=0;
        dfs(count, "ICN", "ICN", tickets);
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        return answer;
    }

    public void dfs(int count, String present, String path, String[][] tickets) {
        if ( count==tickets.length ) {
            answers.add(path);
            return;
        }

        for(int i=0; i<tickets.length; i++) {
            if ( !visit[i] && tickets[i][0].equals(present) ) {
                visit[i] = true;
                dfs(count+1, tickets[i][1], path+ " " + tickets[i][1], tickets);
                visit[i] = false;
            }
        }
        return;
    }
    /*
        Solution 2
        출처 ) https://sohee-dev.tistory.com/104
    */
    static String[][] ticketInfo;
    static boolean[] used;
    static List<String> list = new ArrayList<>();
    static String[] answer = {};

    public String[] solution2(String[][] tickets) {
        used = new boolean[tickets.length];
        ticketInfo = tickets;

        Arrays.sort(ticketInfo, (o1,o2)-> {
            if ( o1[0].equals(o2[0]) ) {
                return o1[1].compareTo(o2[1]);
            } else {
                return o1[0].compareTo(o2[0]);
            }
        });
        list.add("ICN");
        dfs2("ICN", 0);
        return answer;
    }

    public void dfs2(String start, int cnt) {
        if ( answer.length>0) return;

        if ( cnt==used.length ) {
            answer =new String[list.size()];
            for(int i=0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
            return;
        }

        for(int i=0; i<ticketInfo.length; i++) {
            if ( !used[i] && ticketInfo[i][0].equals(start) ) {
                list.add(ticketInfo[i][1]);
                used[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
 
    /*
        My Solution - fail
    */
    // String[] path={};
    // boolean[] visit;

    // public String[] solution2(String[][] tickets) {
    //     String[] tmpPath = new String[tickets.length*2+1];

    //     visit= new boolean[tickets.length];
    //     path = new String[tickets.length*2+1];

    //     for(int i=0; i<tickets.length; i++)
    //         findPath(tickets, i, tmpPath, 0, 0);
        
    //     int cnt=0;
    //     for(int i=0; i<path.length; i++) {
    //         if ( path[i]!=null ) cnt++;
    //     }
    //     String[] ans = new String[cnt];
    //     for(int i=0; i<cnt; i++) {
    //         ans[i] = path[i];
    //     }

    //     return path;
    // }
    
    // private String[] compareOrder(String[] a , String[] b) {
    //     System.out.println( "compareOrder");
    //     int len = Math.min( a.length, b.length );
    //     for(int i=0; i<len; i++) {
    //         if ( a[i] == null && b[i] == null ) return a;
    //         if ( a[i] == null ) return b;
    //         if ( b[i] == null ) return a;
            
    //         int chLen = Math.min( a[i].length(), b[i].length() );
            
    //         for(int j=0; j<chLen; j++) {
    //             if ( a[i].charAt(j) > b[i].charAt(j) ) return a;
    //             if ( a[i].charAt(j) < b[i].charAt(j) ) return b;
    //         }
    //     }
    //     return a;
    // }    

    // private void findPath(String[][] tickets, int idx, String[] tmpPath, int tmpIdx, int k) {
    //     visit[idx]=true;
    //     tmpPath[tmpIdx++] = tickets[idx][0];
    //     // tmpPath[tmpIdx++] = tickets[idx][1];
        
    //     if ( k >= tickets.length-1 ) {
    //         System.out.println( "==== idx : " + idx + " k : " + k + " " + path.length);
    //         tmpPath[tmpIdx++] = tickets[idx][1];
    //         path = compareOrder(tmpPath, path);
    //         return;
    //     }
        
    //     System.out.println( "idx : " + idx + " " + tickets[idx][0] + " -> " + tickets[idx][1] +  " k : " + k );
        
        
    //     String nextAirport = tickets[idx][1];

    //     for(int i=0; i<tickets.length; i++) {
    //         if ( i!=idx && visit[i] == false && tickets[i][0].equals(nextAirport) ) {
    //             findPath(tickets, i, tmpPath, tmpIdx, k+1);
    //         }
    //     }
    //     visit[idx]=false;
    //     tmpIdx-=2;
    // }
    
    // private List<String> compareOrder2(List<String> a, List<String> b) {
    //     int len = Math.min( a.size(), b.size() );

    //     for(int i=0; i<len; i++) {
    //         int chLen = Math.min( a.get(i).length() , b.get(i).length() );

    //         for(int j=0; j<chLen; j++) {
    //             if ( a.get(i).charAt(j) < b.get(i).charAt(j)  ) {
    //                 return b;
    //             } else if ( a.get(i).charAt(j) > b.get(i).charAt(j) ) {
    //                 return a;
    //             }
    //         }
    //     }
    //     return a;
    // }
}
