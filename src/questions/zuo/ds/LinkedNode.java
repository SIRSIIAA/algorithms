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

    /**
     * generate  a string contains value of this node and ALL NODES behind this node
     */
    @Override
    public String toString() {
        var sb = new StringBuilder("[");
        var itr = this;
        while (itr != null) {
            sb.append(itr.data).append(",");
            itr = itr.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.append("]").toString();
    }
}
