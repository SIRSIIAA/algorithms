package questions.zuo.ds;

public class LinkedList {
    private LinkedNode head;
    private LinkedNode tail;
    public LinkedList(){

    }

    public LinkedList(int i){
        addLast(i);
    }

    public void addLast(int i){
        if (head == null){
            head = new LinkedNode(i);
            tail = head;
        }else {
            tail.next = new LinkedNode(i,null,tail);
            tail = tail.next;
        }
    }

    public void addFirst(int i){
        if (head == null){
            head = new LinkedNode(i);
            tail = head;
        }else {
            var node  = new LinkedNode(i,head.next,head);
            if (head.next != null){
                head.next.prev = node;
                head.next = node;
            }else {
                head.next = node;
                tail = node;
            }
        }
    }

    @Override
    public String toString(){
        return head.toString();
    }
}
