package LinkedList;

import cputils.FastReader;
import java.util.Arrays;

class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SortList {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();

        // Read the first list
        int[] list = Arrays.stream(fastReader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Create linked lists from the arrays
        ListNode head = createLinkedList(list);

        // Sort the merged list
        ListNode sortedHead = sortList(head);

        // Print the sorted list
        while (sortedHead != null) {
            System.out.print(sortedHead.val + " ");
            sortedHead = sortedHead.next;
        }
    }

    private static ListNode createLinkedList(int[] list) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int num : list) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return head.next;
    }
    
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode leftNode = head;
        ListNode rightNode = head.next;
        
        while (rightNode != null && rightNode.next != null) {
            leftNode = leftNode.next;
            rightNode = rightNode.next.next;
        }

        ListNode mid = leftNode.next;
        leftNode.next = null;

        leftNode = sortList(head);
        rightNode = sortList(mid);

        return merger(leftNode, rightNode);
    }

    private static ListNode merger(ListNode head1, ListNode head2) {
        ListNode resultantHead = new ListNode(0);
        ListNode resultantCurr = resultantHead;
        ListNode leftCurr = head1;
        ListNode rightCurr = head2;

        while (leftCurr != null && rightCurr != null) {
            if (leftCurr.val < rightCurr.val) {
                resultantCurr.next = leftCurr;
                leftCurr = leftCurr.next;
            } else {
                resultantCurr.next = rightCurr;
                rightCurr = rightCurr.next;
            }
            
            resultantCurr = resultantCurr.next;
        }
        
        while (leftCurr != null) {
            resultantCurr.next = leftCurr;
            leftCurr = leftCurr.next;
            resultantCurr = resultantCurr.next;
        }

        while (rightCurr != null) {
            resultantCurr.next = rightCurr;
            rightCurr = rightCurr.next;
            resultantCurr = resultantCurr.next;
        }


        return resultantHead.next;
    }
}
