import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    2021-10-21
    [JongManBook][Graph-DFS] 고대어 사전
    DFS를 이용한 위상정렬

    문제) https://www.algospot.com/judge/problem/read/DICTIONARY
    참고)
    https://projooni.tistory.com/entry/DFS-%EB%AC%B8%EC%A0%9C-%EA%B3%A0%EB%8C%80%EC%96%B4-%EC%82%AC%EC%A0%84
    https://jaimemin.tistory.com/833
*/
public class AncientDictionary {

    static int[][] adj;
    static boolean[] seen = new boolean[26];
    static List<Integer> order;

    public static void main (String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("C:\\Users\\zwond\\workspace\\Algorithm\\jongmanbook\\28_GraphDFS\\AncientDictionary.txt"));
        // System.setIn(new FileInputStream( ".//AncientDictionary.txt" ) );

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T=Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] words = new String[N];
            for(int i=0; i<N; i++) {
                words[i] = br.readLine().trim();
            }
            makeGraph(words);
            List<Integer> rt = topologicalSort();

            if ( rt.isEmpty() ) {
                bw.write("INVALID HYPOTHESIS");
            }else {
                for(int i=0; i<rt.size(); i++) {
                    bw.write(Character.toString((char)(int)rt.get(i)+'a'));
                }
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
    }

    public static void makeGraph(String[] words) {
        adj=new int[26][26];

        for(int j=1; j<words.length; j++) {
            int i=j-1;
            int len = Math.min( words[i].length(), words[j].length() );
            for(int k=0; k<len; k++) {
                if ( words[i].charAt(k) != words[j].charAt(k) ) {
                    // System.out.println(words[i].charAt(k) + " " + words[j].charAt(k) );
                    int a = words[i].charAt(k)-'a';
                    int b = words[j].charAt(k)-'a';
                    adj[a][b]=1;
                    break;
                }
            }
        }

        // for(int i=0; i<26; i++) {
        //     for(int j=0; j<26; j++) {
        //         System.out.print( adj[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }

    public static void dfs(int here) {
        seen[here]=true;
        for(int there=0; there<adj.length; there++) {
            if ( adj[here][there]==1 && !seen[there] ) { // seen[there] 중요
                dfs(there);
            }
        }
        // System.out.print( Character.toString((char)(int)here+'a'));
        order.add(here);
    }

    public static List<Integer> topologicalSort() {
        int n=adj.length;
        seen = new boolean[n];
        order = new ArrayList<>();


        // dfsAll 역할
        for(int i=0; i<n; i++) {
            if ( !seen[i] ) {
                dfs(i);
            }
        }

        Collections.reverse(order.subList(0, order.size()));
        // for(int i=0; i<order.size(); i++) 
        //     System.out.print( Character.toString((char)(int)(order.get(i)+'a') ));
        // System.out.println();

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if ( adj[order.get(j)][order.get(i)] ==1 ) {
                    return new ArrayList<Integer>();
                }
            }
        }
        return order;
    }


    
}
