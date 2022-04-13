class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next, newHead;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, newHead;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        newHead = reverseList(slow);
        
        slow = head;
        while(newHead != null && slow != null)
        {
            // System.out.println(newHead.val + " "+ slow.val);
            if(slow.val != newHead.val)
            return false;
            else
            {
                slow = slow.next;
            newHead = newHead.next;
            }
        }
        return true;
    }
}