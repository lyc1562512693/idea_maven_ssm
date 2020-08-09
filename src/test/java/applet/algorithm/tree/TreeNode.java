package applet.algorithm.tree;

public class TreeNode {
    public Object value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(Object value){
        this.value = value;
    }
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
