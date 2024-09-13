package questions.zuo.ds;

public class LinkedList {
    private LinkedNode head;
    private LinkedNode tail;

    public LinkedList() {

    }

    public LinkedList(int i) {
        addLast(i);
    }

    public void addLast(int i) {
        if (head == null) {
            initHead(i);
        } else {
            tail.next = new LinkedNode(i, null, tail);
            tail = tail.next;
        }
    }

    /**
     * add an element after the head node
     * head --> head.next
     * -- after addition
     * head --> new node --> head.next(origin)
     */
    public void addFirst(int i) {
        if (head == null) {
            initHead(i);
        } else {
            var node = new LinkedNode(i, head.next, head);
            if (head.next != null) {
                head.next.prev = node;
                head.next = node;
            } else {
                head.next = node;
                tail = node;
            }
        }
    }

    public void addBeforeHead(int i) {
        if (head == null) {
            initHead(i);
        } else {
            var node = new LinkedNode(i, head, null);
            head.prev = node;
            head = node;
        }
    }

    private void initHead(int i) {
        head = new LinkedNode(i);
        tail = head;
    }

    /**
     * implement method of deque
     * {@link java.util.LinkedList} implements interface {@link java.util.Deque}
     */
    public void removeTail() {
        if (tail == null) {
            return;
        }
        tail = tail.prev;
        if (tail == null || tail.prev == null) {
            return;
        }
        tail.next.prev = null;
        tail.next = null;
    }

    public void removeHead() {
        if (head == null) {
            return;
        }
        head = head.next;
        if (head == null || head.prev == null) {
            return;
        }
        head.prev.next = null;
        head.prev = null;
    }

    @Override
    public String toString() {
        return head == null ? "[]" : head.toString();
    }
}
