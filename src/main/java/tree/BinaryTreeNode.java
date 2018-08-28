package tree;

import java.util.LinkedList;

/**
 * @author wangmeng
 * <p>
 * 二叉树的遍历 利用队列的FIFO特性
 * 从根节点开始遍历，根据左右树节点值是否为null来遍历下一层
 */
public class BinaryTreeNode {

    private Object value;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    public BinaryTreeNode(Object value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public static void printIterator(BinaryTreeNode rootNode) {
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);
        while (!queue.isEmpty()) {
            BinaryTreeNode poll = queue.poll();
            System.out.println(poll.getValue());
            if (null != poll.getLeft()) {
                queue.offer(poll.getLeft());
            }
            if (null != poll.getRight()) {
                queue.offer(poll.getRight());
            }
        }

    }

    @Override
    public String toString() {
        return "{ value = " + value + " }";
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1, null, null);
        BinaryTreeNode left1 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode left2 = new BinaryTreeNode(3, null, null);
        BinaryTreeNode right1 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode left3 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode right2 = new BinaryTreeNode(6, null, null);
        root.setLeft(left1);
        root.setRight(right1);
        left1.setLeft(left2);
        left1.setRight(right2);
        left2.setLeft(left3);
        BinaryTreeNode.printIterator(root);
    }
}
