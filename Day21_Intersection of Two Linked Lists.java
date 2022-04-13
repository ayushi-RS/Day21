public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // while(headA)
        int d = 100000;
        ListNode currA = headA, currB = headB, ans = new ListNode();
        while(currA != null)
        {
            currA.val += d;
            currA = currA.next;
        }
        while(currB != null)
        {
            if(currB.val > d)
            {
                ans = currB;
                break;
            }
            currB = currB.next;
        }
        while(headA != null)
        {
            headA.val -= d;
            headA = headA.next;
        }
        while(headB != null)
        {
            if(headB.val > d)
            headB.val -= d;
            headB = headB.next;
        }
        return ans.val == 0? null : ans;
    }
}