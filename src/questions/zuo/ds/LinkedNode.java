package questions.zuo.ds;

public class LinkedNode {
    public LinkedNode next;
    public LinkedNode prev;
    public int data = 0;
    public LinkedNode(){}
    public LinkedNode(int data) {
        this.data = data;
    }
    public LinkedNode(int data, LinkedNode next, LinkedNode prev) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
