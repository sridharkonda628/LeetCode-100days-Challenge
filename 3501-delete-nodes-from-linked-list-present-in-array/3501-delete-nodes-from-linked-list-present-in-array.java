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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> s1 = new HashSet<>();
        int n= nums.length;
        for(int i=0;i<n;i++){
            s1.add(nums[i]);
        }

        ListNode dp = new ListNode(-1);
        ListNode prev =dp;
       
        while(head!=null){
            if(!s1.contains(head.val)){
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;
        }
        prev.next = null;
        return dp.next;

    }
}