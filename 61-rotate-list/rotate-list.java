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
        if(head==null){
            return null;
        }
        ListNode end=head;
        int len=1;
        while(end.next!=null){
            end=end.next;
            len++;
        }
        end.next=head;
        k=k%len;
        for(int i=0;i<(len-k);i++){
            end=end.next;
        }
        head=end.next;
        end.next=null;
        return head;
    }
}