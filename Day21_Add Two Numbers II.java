class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=rev(l1);
        l2=rev(l2);
        ListNode result=addTwoNum(l1,l2);
        return rev(result);
    }
    public ListNode rev(ListNode node){
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    public ListNode addTwoNum(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode temp=result;
        int bit=0;
        while(l1!=null && l2!=null){
            int sum=l1.val+l2.val;
            if(bit > 0){
                sum=sum+bit;
                bit=0;
            }
            if(sum > 9){
                sum=sum%10;
                bit++;
            }
            temp.next=new ListNode(sum);
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum=l1.val;
            if(bit > 0){
                sum=sum+bit;
                bit=0;
            }
            if(sum > 9){
                sum=sum%10;
                bit++;
            }
            temp.next=new ListNode(sum);
            temp=temp.next;
            l1=l1.next;
        }
        while(l2!=null){
            int sum=l2.val;
            if(bit > 0){
                sum=sum+bit;
                bit=0;
            }
            if(sum > 9){
                sum=sum%10;
                bit++;
            }
            temp.next=new ListNode(sum);
            temp=temp.next;
            l2=l2.next;
        }
        if(bit > 0){
            temp.next=new ListNode(1);
        }
        result=result.next;
        return result;
    }
}