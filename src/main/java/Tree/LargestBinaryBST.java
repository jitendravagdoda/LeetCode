package Tree;

public class LargestBinaryBST {
    public static void main(String[] args) {

        Node root=new Node(25);
        root.left=new Node(18);
        root.right=new Node(50);
        root.left.left=new Node(19);
        root.left.right=new Node(20);
        root.left.left.right=new Node(15);
        root.left.right.left=new Node(18);
        root.left.right.right=new Node(25);
        root.right.left=new Node(35);
        root.right.right=new Node(60);
        root.right.left.left=new Node(20);
        root.right.left.right=new Node(40);
        root.right.left.left.right=new Node(25);
        root.right.right.left=new Node(55);
        root.right.right.right=new Node(70);
        BinaryTree bt=new BinaryTree(root);
        bt.breadthFirstTravsal(root);

        LargestBinaryBST largestBinaryBST=new LargestBinaryBST();
        System.out.println(largestBinaryBST.largestBST(root));

        System.out.println("Depth of tree "+largestBinaryBST.maxDepth(root));
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


