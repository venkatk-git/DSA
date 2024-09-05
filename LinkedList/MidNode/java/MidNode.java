package LinkedList.MidNode.java;

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MidNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        System.out.println((middleNode(head).val));
    }

    /** Brute Force 
    ** private static ListNode middleNode(ListNode head){
    **     ListNode curr = head;
    **     int length = 0;
    ** 
    **     while(curr != null){
    **         length += 1;
    **         curr = curr.next;
    **     }
    ** 
    **     curr = head;
    **     for(int i = 0; i < length / 2; i++)
    **         curr = curr.next;
    ** 
    **     return curr;
    ** }
    */

    /* Slow & Fast Pointer Approach */
    public static ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null){
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


}
