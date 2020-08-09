package applet.algorithm.tree;

import java.util.*;

/**
 * 1. 二叉树的前序/中序/后序遍历（递归&非递归） ；
 * 2. 二叉树的层序遍历 ；
 * 3. 求二叉树的高度  ；
 * 4. 求二叉树的叶子节点的个数 ；
 * 5. 求二叉树第k层的节点个数 ；
 * 6. 判断一个节点是否在一棵二叉树中 ；
 * 7.从二叉树中查找结点
 * 8.判断两颗二叉树是否相等；
 * 9.求二叉树的镜像；
 */
public class TreeUtils {
    public static void main(String[] args) {
        TreeNode root = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");

        root.left = nodeB;
        root.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.left = nodeF;
        nodeC.right = nodeG;
        System.out.println("递归为神>>>");
        prePrintRecursion(root);
        System.out.println();
        midPrintRecursion(root);
        System.out.println();
        postPrintRecursion(root);
        System.out.println();
        System.out.println("迭代为人>>>");
        prePrint(root);
        System.out.println();
        midPrint(root);
        System.out.println();
        postPrint(root);
        System.out.println();
        levelPrint(root);
        System.out.println();
        levelPrintPro(root);
        System.out.println("树高度>>>");
        System.out.println(getHeight(root));
        System.out.println("树总结点个数和数叶子节点个数>>>");
        System.out.println(totalNodeSize(root));
        System.out.println(totalLeafSize(root));
        System.out.println("第k层节点数>>>");
        System.out.println(getKLevelSize(root, 2));
        System.out.println("判断一个节点是否再树中>>>");
        System.out.println(isExist(root, "D"));
        System.out.println("判断一个节点是否再树中，若再返回该节点对应的子树，否则返回空>>>");
        TreeNode node = getTreeByValue(root,"B");
        postPrintRecursion(node);
        System.out.println();
        System.out.println("判断两颗树是否相等>>>");
        System.out.println(equalsTree(root, root));
        System.out.println("树镜像>>>");
        mirrorTree(root);
        prePrintRecursion(root);
    }

    /**
     * 递归前序遍历-根左右
     * @param root
     */
    public static void prePrintRecursion(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.value);
        prePrintRecursion(root.left);
        prePrintRecursion(root.right);
    }

    /**
     * 递归中序遍历-左根右
     * @param root
     */
    public static void midPrintRecursion(TreeNode root){
        if(root == null){
            return;
        }
        midPrintRecursion(root.left);
        System.out.print(root.value);
        midPrintRecursion(root.right);
    }

    /**
     * 递归后序遍历-左右根
     * @param root
     */
    public static void postPrintRecursion(TreeNode root){
        if(root == null){
            return;
        }
        postPrintRecursion(root.left);
        postPrintRecursion(root.right);
        System.out.print(root.value);
    }

    /**
     * 非递归前序遍历（借用栈先进后出的特性）
     * add等效push
     * @param root
     */
    public static void prePrint(TreeNode root){
        if(root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);//为了保证能进入下面while
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.value);
            if(node.right != null){stack.add(node.right);}//由于后进先出，所以right先进
            if(node.left != null){stack.add(node.left);}
        }
    }

    /**
     * 非递归中序遍历（栈）
     * @param root
     */
    public static void midPrint(TreeNode root){
        if(root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null){
            while(current != null){//先找到最左节点，并将这个过程中遍历到的节点依次入栈
                stack.add(current);
                current = current.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.value);
            if(node.right != null){current = node.right;}//注意这里是赋值给current节点，当前节点后面还有担当起找以当前节点为根，找最左节点的重任
        }
    }

    /**
     * 非递归后序遍历（栈）
     * 再前序遍历的基础上，将左先入栈，右后入，最后输出的是根右左，正好喝后序遍历的左右根相反，所以再将输出打印过程换成入到一个新栈，最后再打印新栈即为左右根
     * @param root
     */
    public static void postPrint(TreeNode root){
        if(root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            stack2.add(node);
            if(node.left != null){stack.add(node.left);}
            if(node.right != null){stack.add(node.right);}
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().value);
        }
    }

    /**
     * 层序遍历（借用队列先进先出特性，写法和前序遍历很像）
     * @param root
     */
    public static void levelPrint(TreeNode root){
        if(root == null)return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.value);
            if(node.left != null){queue.add(node.left);}//就这里顺序反了
            if(node.right != null){queue.add(node.right);}
        }
    }

    /**
     * 层序遍历：输出每层元素（队）
     * @param root
     * @return
     */
    public static List<List<Object>> levelPrintPro(TreeNode root){
        List<List<Object>> outLst = new ArrayList<>();
        if(root == null)return outLst;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){//每次根据前期队列大小，循环将队列中所有节点拿出入新集合
            int size = queue.size();
            List<Object> inLst = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = queue.poll();
                inLst.add(node.value);
                if(node.left != null){queue.add(node.left);}
                if(node.right != null){queue.add(node.right);}
            }
            outLst.add(inLst);
        }
        return outLst;
    }

    /**
     * 树高度-递归方式：每次都比较每个节点左右子树的高度，取高的加1
     * @param root
     * @return
     */
    public static int getHeight(TreeNode root){
        if(root == null){return 0;}
        int left = getHeight(root.getLeft());
        int right = getHeight(root.getRight());
        return left > right ? ++left : ++right;
    }

    /**
     * 树总结点个数
     * @param root
     * @return
     */
    public static int totalNodeSize(TreeNode root){
        if(root == null){return 0;}
        return totalNodeSize(root.getLeft()) + totalNodeSize(root.getRight()) + 1;//这个1是根节点
    }

    /**
     * 树叶子节点个数
     * @param root
     * @return
     */
    public static int totalLeafSize(TreeNode root){
        if(root == null){return 0;}
        if(root.left == null && root.right == null){return 1;}//左右节点都为空的为叶子
        return totalLeafSize(root.left) + totalLeafSize(root.right);
    }

    /**
     * 第k层节点数
     * @param root
     * @param k
     * @return
     */
    public static int getKLevelSize(TreeNode root,int k){
        if(root == null){return 0;}
        if(k == 1){return 1;}
        return getKLevelSize(root.left, k-1) + getKLevelSize(root.right, k-1);
    }

    /**
     * 判断一个节点是否再树中
     * @param root
     * @param x
     * @return
     */
    public static boolean isExist(TreeNode root, Object x){
        if(root == null){return false;}
        if(x.toString().equals(root.value.toString())){return true;}//当前节点找的到即返回true
        return isExist(root.left, x) || isExist(root.right, x);//找不到则去其两个子树中找
    }

    /**
     * 判断指定节点是否再树中，再的话返回该节点，否则返回空
     * @param root
     * @param x
     * @return
     */
    public static TreeNode getTreeByValue(TreeNode root, Object x){
        if(root == null){return null;}
        if(x.toString().equals(root.value.toString())){return root;}
        TreeNode node = getTreeByValue(root.left,x);
        if(x.toString().equals(node.value.toString())){return node;}
        return getTreeByValue(root.right, x);
    }

    /**
     * 判断两颗树是否相等
     * @param root1
     * @param root2
     * @return
     */
    public static boolean equalsTree(TreeNode root1, TreeNode root2){
        //都为空直接相等
        if(root1 == null && root2 == null){return true;}
        //如果都不为空且当前节点值相等且当前节点左节点递归相等且右节点递归相等才返回true
        if(root1 != null && root2 != null && root1.value.toString().equals(root2.value.toString()) && equalsTree(root1.left,root2.left) && equalsTree(root1.right, root2.right)){return  true;}
        //否则不相等
        return false;
    }
    /**
     * 二叉树镜像-直接交换每个节点的左右孩子即可
     * @param root
     */
    public static void mirrorTree(TreeNode root){
        if(root == null){return ;}
        if(root.left == null && root.right == null){return;}
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
    }
}
