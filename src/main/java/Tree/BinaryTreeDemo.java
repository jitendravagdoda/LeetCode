package Tree;

import java.util.LinkedList;

class Node{
    int num;
    Node left,right;
    Node(int num){
        this.num=num;
        left=null;
        right=null;
    }
}

class BinaryTree{
    Node root;
    BinaryTree(Node node){
        root=node;
    }

    public void preOrder(Node node){
        if(node==null) return;
        System.out.print(node.num +" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node){
        if(node==null) return;
        inOrder(node.left);
        System.out.print(node.num+" ");
        inOrder(node.right);
    }
    public void postOrder(Node node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.num+" ");
    }
    public void breadthFirstTravsal(Node node){

        LinkedList<Node> queue=new LinkedList();
        queue.add(node);
        while(queue.size()!=0){
            int length=queue.size();
            for (int i = 0; i<length ; i++) {
                Node temp=queue.removeLast();
                System.out.print(temp.num+" ");
                if(temp.left !=null) queue.push(temp.left);
                if(temp.right !=null) queue.push(temp.right);
            }
            System.out.println();
        }
    }

    public Node mergetTwoBinaryTree(Node b1, Node b2){
        if(b1==null && b2==null) return null;
        int val= (b1==null? 0:b1.num) + (b2==null? 0:b2.num);
        Node root=new Node(val);
        root.left=mergetTwoBinaryTree((b1==null? null:b1.left),(b2==null? null:b2.left));
        root.right=mergetTwoBinaryTree((b1==null? null:b1.right),(b2==null? null:b2.right));
        return root;
    }

    public Node lowestCommonAncetor(Node node, int n1,int n2){
        if(node == null) return null;
        if(node.num==n1 || node.num==n2) return node;

        node.left=lowestCommonAncetor(node.left,n1,n2);
        node.right=lowestCommonAncetor(node.right,n1,n2);

        if(node.left!=null && node.right!=null) return node;

        if(node.left==null && node.right==null) return null;

        return node.left!=null? node.left:node.right;
    }

    public boolean isBST(Node node, int min, int max){
        if (node == null) return true;
        if(node.num<min && node.num>=max) return false;
        return isBST(node.left,min,node.num) && isBST(node.right,node.num,max);
    }
}

public class BinaryTreeDemo {
    public static void main(String[] args) {

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        root.right.right.right=new Node(8);
        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);
        root1.right.left=new Node(3);
        root1.right.right=new Node(5);
        BinaryTree bt=new BinaryTree(root);
        bt.breadthFirstTravsal(root1);

//        Node mergeTreeNode = bt.mergetTwoBinaryTree(root,root1);
//
//
//        bt.breadthFirstTravsal(root);
//
//        System.out.println(bt.lowestCommonAncetor(root,8,4).num);
//        System.out.println("IsBST "+bt.isBST(root1,Integer.MIN_VALUE,Integer.MAX_VALUE));

    }
}

