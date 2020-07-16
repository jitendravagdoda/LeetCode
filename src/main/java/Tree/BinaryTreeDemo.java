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

    class BinaryTree {
        Node root;
        int max;

        BinaryTree(Node node) {
            root = node;
            max=0;
        }

        public void preOrder(Node node) {
            if (node == null) return;
            System.out.print(node.num + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

        public void inOrder(Node node) {
            if (node == null) return;
            inOrder(node.left);
            System.out.print(node.num + " ");
            inOrder(node.right);
        }

        public void postOrder(Node node) {
            if (node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.num + " ");
        }

        public void breadthFirstTravsal(Node node) {

            LinkedList<Node> queue = new LinkedList();
            queue.add(node);
            while (queue.size() != 0) {
                int length = queue.size();
                for (int i = 0; i < length; i++) {
                    Node temp = queue.remove();
                    System.out.print(temp.num + " ");
                    if (temp.left != null) queue.add(temp.left);
                    if (temp.right != null) queue.add(temp.right);
                }
                System.out.println();
            }
        }

        public Node mergeTwoBinaryTree(Node n1, Node n2) {
            if (n1 == null && n2 == null) {
                return null;
            }
            if (n1 == null)
                return n2;
            if (n2 == null)
                return n1;
            int val = (n1 == null ? 0 : n1.num) + (n2 == null ? 0 : n2.num);
            Node root = new Node(val);
            root.left = mergeTwoBinaryTree(n1 == null ? null : n1.left, n2 == null ? null : n2.left);
            root.right = mergeTwoBinaryTree(n1 == null ? null : n1.right, n2 == null ? null : n2.right);
            return root;

        }

        public Node lowestCommonAncetor(Node node, int n1, int n2) {
            if (node == null)
                return null;
            else if (node.num == n1 || node.num == n2)
                return node;
            Node left = lowestCommonAncetor(node.left, n1, n2);
            Node right = lowestCommonAncetor(node.right, n1, n2);
            if (left != null && right != null)
                return node;
            else if (left == null && right == null)
                return null;
            return left == null ? right : left;
        }

        public boolean isBST(Node node, int min, int max) {
            if (node == null)
                return true;
            else if (node.num < min || node.num > max)
                return false;
            else
                return isBST(node.left, min, node.num) && isBST(node.right, node.num, max);
        }

        public Node inorderSuccessor(Node root, Node p) {
            if (root == null || p == null)
                return null;
            Node successor = null;
            while (root != null) {
                if (root.num > p.num) {
                    successor = root;
                    root = root.left;
                } else root = root.right;
            }
            return successor;
        }


        public Node inOrderSuccessorRecursive(Node root, Node p) {
            if (root == null || p == null)
                return null;
            if (root.num > p.num) {
                Node left = inOrderSuccessorRecursive(root.left, p);
                return (left != null) ? left : root;
            } else
                return inOrderSuccessorRecursive(root.right, p);
        }


        public Node predecessor(Node root, Node p) {
            if (root == null)
                return null;
            if (p.num > root.num) {
                Node right = predecessor(root.right, p);
                return right != null ? right : root;
            } else
                return predecessor(root.left, p);

        }
        public int helper(Node root){
            if(root==null)
                return 0;
            int left=helper(root.left);
            int right=helper(root.right);
            int leftcount=0, rightcount=0;
            if(root.left!=null && root.num==root.left.num)
                leftcount=left+1;
            if(root.right!=null && root.num==root.right.num)
                rightcount=right+1;
            max=Math.max(max,leftcount+rightcount);
            return Math.max(leftcount,rightcount);
        }

        public int unique(Node node, int count){
            if(node == null)
                return count;
            node.num= count++;
            count = unique(node.left,count);
            count=unique(node.right,count);
            return count;
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
            Node root1=new Node(5);
            root1.left=new Node(4);
            root1.right=new Node(8);
            root1.right.left=new Node(6);
            root1.right.right=new Node(9);
            BinaryTree bt=new BinaryTree(root);
            bt.breadthFirstTravsal(root);
            bt.unique(root,0);
            bt.breadthFirstTravsal(root);
//            System.out.println("==========");
//            bt.inOrder(root1);
//            System.out.println();
//            System.out.println("===========");
//            Node mergeTree=bt.mergeTwoBinaryTree(root, root1);
//            Node temp=new Node(5);
//            bt.breadthFirstTravsal(root1);
//            System.out.println(bt.inOrderSuccessorRecursive(root1,temp).num);
//            System.out.println(bt.predecessor(root1,temp).num);
    //        bt.breadthFirstTravsal(mergeTree);
    //        System.out.println(bt.isBST(root1,Integer.MIN_VALUE, Integer.MAX_VALUE));
    //        Node lowestComman=bt.lowestCommonAncetor(root,4,15);
    //        System.out.println(lowestComman.num);

        }
    }

