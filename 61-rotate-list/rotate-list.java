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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode end=head;
        int len=1;
        if(head==null){
            return null;
        }
        while(end.next!=null){
            end=end.next;
            len++;
        }
        end.next=head;
        if(k>len)
            k=k%len;
        for(int i=0;i<(len-k);i++){
            head=head.next;
            end=end.next;
        }
        end.next=null;
        return head;
    }
}