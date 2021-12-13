import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    2021-12-13
    [Leetcode][Easy] 234. Palindrome Linked List
*/

class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
        My Solution
        Runtime: 9 ms, faster than 37.19% of Java online submissions for Palindrome Linked List.
        Memory Usage: 51.8 MB, less than 50.11% of Java online submissions for Palindrome Linked List.

        수정사항 
            - return 을 먼저 
            - stack의 size 반까지만 확인하도록 변경
        Runtime: 8 ms, faster than 41.22% of Java online submissions for Palindrome Linked List.
        Memory Usage: 51.3 MB, less than 59.95% of Java online submissions for Palindrome Linked List.
    */
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        
        ListNode h = head;
        while( h.next != null ) {
            // System.out.println( h.val );
            st.add(h);
            h = h.next;
        }
        st.add(h);

        h = head;

        int size = st.size();

        while( !st.isEmpty() ) {
            if ( h.val != st.pop().val ) {
                return false;
            }
            h = h.next;
            if( st.size() < (size-1)/2 ) break;
        }
        return true;
    } 

    /*
        Runtime: 16 ms, faster than 19.41% of Java online submissions for Palindrome Linked List.
        Memory Usage: 53.2 MB, less than 41.55% of Java online submissions for Palindrome Linked List.
    */
    public boolean isPalindrome2(ListNode head) {
        if ( head == null ) return true;
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();

        while( head!=null ) {
            s.add(head.val);
            q.add(head.val);
            head = head.next;
        }

        int size = q.size();
        while( !q.isEmpty() ) {
            if ( q.poll() != s.pop() ) {
                return false;
            }
            if ( q.size() < (size-1)/2 ) break;
        }
        return true;
    }
    
    public static void main(String[] args) {
        PalindromeLinkedList p = new PalindromeLinkedList();

        ListNode h4 = new ListNode(1);
        ListNode h3 = new ListNode(2, h4);
        ListNode h2 = new ListNode(2, h3);
        ListNode h1 = new ListNode(1, h2);
        System.out.println( p.isPalindrome(h1) );
    }
}
