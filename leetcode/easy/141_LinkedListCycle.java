/* 
    2021-08-24

플로이드의 순환 알고리즘 (토끼와 거북이 알고리즘)
-> cycle 유무 찾기

https://nol2soft.wordpress.com/2013/07/13/linked-list-cycle-detection-explanation/
https://heod.tistory.com/2
https://fierycoding.tistory.com/45

    Success
    Details 
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
    Memory Usage: 40.1 MB, less than 47.90% of Java online submissions for Linked List Cycle. 
 */


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        ListNode first = head, second = head;

        while( first != null && first.next != null ) {
            first = first.next.next;
            second = second.next;

            if ( first == second ) {
                return true;
            }
        }
        return false;
        
    }
}
