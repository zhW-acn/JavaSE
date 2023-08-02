import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RecursiveBinaryTree {

    private static class Node {
        Integer data;
        Node left;
        Node right;

        public Node(Integer data) {
            this.data = data;
        }
    }

    private static void pre(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);//根结点压入栈，使栈非空
        while (!stack.isEmpty()) {
            node = stack.pop();//目标结点出栈
            if (null != node) {
                System.out.print(node.data);
                stack.push(node.right);//右孩子先压入栈
                stack.push(node.left);//左孩子后压入栈，保证出栈顺序正确
            }
        }
    }

    private static void mid(Node node) {
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || null != node) {//栈非空 || 结点非空
            if (null != node) {//结点非空   这个if的作用是把所有偏左子树结点入栈
                stack.push(node);//沿左子树方向入栈
                node = node.left;
            }else{//结点为空，说明上一个入栈结点是树的最左结点 或 是有左结点的根节点
                node = stack.pop();
                System.out.print(node.data);
                node = node.right;//再访问右结点
            }
        }
    }

    private static void post(Node node){
        Stack<Node> stack = new Stack<>();
        Node VisitedNode = null;
        while(null != node || !stack.isEmpty()){
            while(null != node){//结点非空，沿左子树方向入栈
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();//该节点是叶节点或左子树全部访问完毕，取栈顶
            if(null != node.right && VisitedNode !=node.right){//如果存在右结点 且 右结点未被访问，进入右子树
                node = node.right;
            }
            else {//该结点是叶节点或右结点已被访问(左右根，该结点下的全部结点都被访问了或为null)
                System.out.print(node.data);
                VisitedNode = node;
                node = null;//防止重复访问左结点 ->  while(null != node)
                stack.pop();
            }
        }
    }

    private static void pre_recursive(Node node) {//先序：根左右
        if (null == node) {
            return;
        }
        System.out.print(node.data);
        pre_recursive(node.left);
        pre_recursive(node.right);
    }

    private static void mid_recursive(Node node) {//中序：左根右
        if (null == node) {
            return;
        }
        mid_recursive(node.left);
        System.out.print(node.data);
        mid_recursive(node.right);
    }

    private static void post_recursive(Node node) {//后序：左右根
        if (null == node) {
            return;
        }
        post_recursive(node.left);
        post_recursive(node.right);
        System.out.print(node.data);
    }

    private static void ceng(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            node = queue.poll();
            if(null != node.left)
                queue.offer(node.left);
            else ;
            if(null != node.right)
                queue.offer(node.right);
            System.out.print(node.data);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("先序遍历--------");
        pre(root);
        System.out.println("\r");
        pre_recursive(root);
        System.out.println("\n中序遍历--------");
        mid(root);
        System.out.println("\r");
        mid_recursive(root);
        System.out.println("\n后序遍历--------");
        post(root);
        System.out.println("\r");
        post_recursive(root);
        System.out.println("\n层序遍历--------");
        ceng(root);

    }

}
