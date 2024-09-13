package questions.zuo.ds;

public class EasyTreeNode {
    public int data;
    public EasyTreeNode left;
    public EasyTreeNode right;

    public EasyTreeNode(int i) {
        data = i;
    }

    public EasyTreeNode(int i, EasyTreeNode left, EasyTreeNode right) {
        this(i);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return data + "";
    }
}