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
    public int pairSum(ListNode head) {
        int sum=Integer.MIN_VALUE;

        //by slow fast method find middle and divide the list in two
        ListNode slow=head;
        ListNode fast=head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        while(fast!=null){
            prev=prev.next;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;

        //reverse the second list whose head is slow
        ListNode newHead=null;
        ListNode curr=slow;
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=newHead;
            newHead=curr;
            curr=nextNode;
        }

        //now traverse both list and add the heads and check sum
        while(head!=null){
            sum=Math.max(sum,head.val+newHead.val);
            head=head.next;
            newHead=newHead.next;
        }

        //return the max
        return sum;
    }
}