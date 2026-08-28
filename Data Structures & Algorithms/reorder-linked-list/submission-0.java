/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        ListNode prev = slow.next= null;
        while(curr!=null) {
            ListNode next = curr.next;
            curr.next= prev;
            prev = curr;
            curr= next;
        }
        
        slow = head;
        while(prev!=null) {
            ListNode t1 = slow.next;
            ListNode t2 = prev.next;
            slow.next = prev;
            prev.next =t1;
            prev = t2;
            slow = t1;
        }

    }
}
