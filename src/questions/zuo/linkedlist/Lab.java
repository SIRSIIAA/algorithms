package questions.zuo.linkedlist;

import questions.zuo.ds.LinkedNode;
import utils.parser.CommonInputParser;

public class Lab {
    /*
     * reverse the LinkedList by double pointer
     * ref: https://leetcode.cn/problems/reverse-linked-list/description/
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

    /*
     * merge two sorted linklist to one
     * ref: https://leetcode.cn/problems/merge-two-sorted-lists/description/
     */
    public LinkedNode merge(LinkedNode head1, LinkedNode head2) {
        var h1 = head1;
        var h2 = head2;
        var dummy = new LinkedNode();
        var pointer = dummy;
        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                pointer.next = h1;
                h1 = h1.next;
            } else {
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
     *  calculate two decimal number (linklist), return the result by one linklist
     *  ref: https://leetcode.cn/problems/add-two-numbers/description/
     */
    public static LinkedNode getSum(LinkedNode head1, LinkedNode head2) {
        var dummy = new LinkedNode();
        var pointer = dummy;
        int carriage = 0;
        for (int sum, val = 0; head1 != null || head2 != null;
             head1 = (head1 == null) ? null : head1.next,
                 head2 = (head2 == null) ? null : head2.next) {
            val = (head1 == null ? 0 : head1.data) + (head2 == null ? 0 : head2.data);
            sum = (val + carriage) % 10;
            carriage = (val + carriage) / 10;
            pointer.next = new LinkedNode(sum);
            pointer = pointer.next;
        }
        if (carriage == 1) {
            pointer.next = new LinkedNode(carriage);
        }
        return dummy.next;
    }

    /*
     *  divide a linklist by target
     *  ref: https://leetcode.cn/problems/partition-list/description/
     */
    public static LinkedNode division(LinkedNode head, int target) {
        var lessLeft = new LinkedNode();
        var lessRight = lessLeft;
        var moreLeft = new LinkedNode();
        var moreRight = moreLeft;
        var pointer = head;
        while (pointer != null) {
            var tmp = pointer.next;
            if (pointer.data > target) {
                moreRight.next = pointer;
                moreRight = moreRight.next;
            } else {
                lessRight.next = pointer;
                lessRight = lessRight.next;
            }
            pointer.next = null;
            pointer = tmp;
        }
        lessRight.next = moreLeft.next;
        return lessLeft.next;
    }

    public static void main(String[] args) {
        /*
         *  getSum test
         */
        String input1 = "[2,4,3]";
        String input2 = "[5,6,4]";
        System.out.println(getSum(CommonInputParser.parseLinkedListFromString(input1),
            CommonInputParser.parseLinkedListFromString(input2)));
        /*
         * division test
         */
        String input3 = "[6,5,3,4,2,1,1,7]";
        int target = 4;
        System.out.println(division(CommonInputParser.parseLinkedListFromString(input3), target));
    }
}
