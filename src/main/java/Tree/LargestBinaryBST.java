package Tree;
import java.util.*;

public class LargestBinaryBST {
    int result =0;
    public static void main(String[] args) {

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.left.left.right=new Node(6);
        root.left.right.left=new Node(7);
        root.left.right.right=new Node(8);
        root.right.left=new Node(9);
        root.right.right=new Node(10);
        root.right.left.left=new Node(11);
        root.right.left.right=new Node(12);
        root.right.left.left.right=new Node(13);
        root.right.right.left=new Node(14);
        root.right.right.right=new Node(15);
        BinaryTree bt=new BinaryTree(root);
        bt.breadthFirstTravsal(root);

        LargestBinaryBST largestBinaryBST=new LargestBinaryBST();
        System.out.println(largestBinaryBST.largestBST(root));

        System.out.println("Depth of tree "+largestBinaryBST.maxDepth(root));
        System.out.println(largestBinaryBST.product(root,4));
    }

    int largestBST(Node node){

        return checkBST(node).size;
    }

    MinMax checkBST(Node node){
        if(node==null)
            return new MinMax();
        MinMax left= checkBST(node.left);
        MinMax right=checkBST(node.right);

        MinMax temp=new MinMax();

        if( left.isBST==false || right.isBST==false || left.max>node.num || right.min<node.num){
            temp.isBST=false;
            temp.size=Math.max(left.size,right.size);
            return temp;
        }
        temp.isBST=true;
        temp.size=left.size+right.size+1;
        temp.min=node.left==null?node.num:left.min;
        temp.max=node.right ==null?node.num:right.max;

        return temp;
    }

    int maxDepth(Node root){
        if(root == null) return 0;

        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    int product(Node root, int num){
        if(root == null)
            return 0;
        Set<Integer> set = new HashSet();
        helper(root, num, set, 1);

        return result;
    }

    public void helper(Node node, int num, Set<Integer> set, int i) {
        if(node == null){
            System.out.println(set.toString());
        }else {
                set.add(node.num);
                System.out.println(set.toString());
                i *= node.num;
                helper(node.left, num,set,i);
                set.remove(node.num);
                helper(node.right, num, set, i);
            }
    }
}



class MinMax{
    boolean isBST;
    int size;
    int min;
    int max;
    MinMax(){
        isBST=true;
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;
        size=0;

    }
}


