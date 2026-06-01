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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        
        int carry = 0;
        
        // Loop as long as there are nodes left in EITHER list, OR if we have a carry left over
        while (l1 != null || l2 != null || carry != 0) {
            
            // If the list has run out of nodes, treat the missing digit as 0
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            // Add the two digits plus whatever we carried over from the last step
            int sum = x + y + carry;
            
            // The new carry is the tens digit (e.g., if sum is 15, carry becomes 1)
            carry = sum / 10;
            
            // The new node gets the ones digit (e.g., if sum is 15, node becomes 5)
            current.next = new ListNode(sum % 10);
            
            // Move all of our pointers forward for the next loop
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // Return the actual start of the list (skipping the initial dummy node)
        return dummyHead.next;
    }
}