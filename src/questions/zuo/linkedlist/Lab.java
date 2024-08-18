package questions.zuo.linkedlist;

import questions.zuo.ds.LinkedNode;

public class Lab {
    /*
     * reverse the LinkedList by double pointer 
     */
    public LinkedNode reverse(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode pre = null;
        LinkedNode cur = head;
        while (cur != null) {
            var next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public LinkedNode merge(LinkedNode head1,LinkedNode head2){
        var h1 = head1;
        var h2 = head2;
        var dummy = new LinkedNode();
        var pointer = dummy;
        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                pointer.next = h1;
                h1 = h1.next;
            }else{
                pointer.next = h2;
                h2 = h2.next;
            }
            pointer = pointer.next;
        }
        if (h1 != null) {
            pointer.next = h1;
        }
        if (h2 != null) {
            pointer.next = h2;
        }
        return dummy.next;
    }

    /*
     * FIXME 
     */
    public LinkedNode getSum(LinkedNode head1, LinkedNode head2){
        var dummy = new LinkedNode();
        var pointer = dummy;
        int carriage = 0;
        for(int sum, val = 0; 
                head1 != null || head2 != null;
                head1 = (head1 == null) ? null : head1.next, head2 = (head2 == null)? null : head2.next){

        }
        return dummy.next;
    }
}
