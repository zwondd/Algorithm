/*
    2021-12-14
    [Leetcode][Medium] 721. Accounts Merge
*/
import java.util.*;

class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();

        // owner : email -> email
        // parent : eamil -> name

        for(List<String> a : accounts) {
            for(int i=1; i<a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        Set set = parents.entrySet();
        Iterator it = set.iterator();
        while( it.hasNext() ) {
            Map.Entry<String, String> ent = (Map.Entry<String, String>)it.next();
            System.out.println(ent.getKey() + " " + ent.getValue());
        }
        System.out.println("================================");
        System.out.println();
        System.out.println();
        System.out.println();
        

        // update parent
        for(List<String> a: accounts) {
            String p = find(a.get(1), parents);
            System.out.println("p : " + p);
            for(int i=2; i<a.size(); i++) {
                parents.put(find(a.get(i), parents), p);
            }
            set = parents.entrySet();
            it = set.iterator();
            while( it.hasNext() ) {
                Map.Entry<String, String> ent = (Map.Entry<String, String>)it.next();
                System.out.println(ent.getKey() + " " + ent.getValue());
            }
            System.out.println();
            System.out.println("================================");
            
        }

        // add to name
        for(List<String> a : accounts) {
            String p = find(a.get(1), parents);
            if ( !unions.containsKey(p) ) {
                unions.put(p, new TreeSet<>());
            }
            for(int i=1; i<a.size(); i++) {
                unions.get(p).add(a.get(i));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(String p : unions.keySet()) {
            List<String> emails = new ArrayList<>(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
        
    }
    private String find(String s , Map<String, String> p) {
        return p.get(s) == s? s : find(p.get(s), p);
    }

    public static void main(String[] args) {
        List<String> a1 = Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com");
        List<String> a2 = Arrays.asList("John","johnsmith@mail.com","john00@mail.com");
        List<String> a3 = Arrays.asList("Mary","mary@mail.com");
        List<String> a4 = Arrays.asList("John","johnnybravo@mail.com");

        List<List<String>> test = new ArrayList<>();
        test.add(a1);
        test.add(a2);
        test.add(a3);
        test.add(a4);

        AccountsMerge am = new AccountsMerge();
        am.accountsMerge(test);
    }
}
