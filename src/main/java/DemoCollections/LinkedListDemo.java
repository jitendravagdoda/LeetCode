package DemoCollections;

import java.util.*;

public class LinkedListDemo {
    public static void main(String args[]) {
        LinkedListDemo linkedListDemo =new LinkedListDemo();
        Node first = new Node(2);
        first.next = new Node(4);
        first.next.next = new Node(6);

        Node second = new Node(5);
        second.next = new Node(6);
        second.next.next = new Node(4);
        second.next.next.next = new Node(9);
        Node reverseAdd= linkedListDemo.reverseOrder(first, second);
        linkedListDemo.display(reverseAdd);

        Node add =linkedListDemo.addition(first, second);
        linkedListDemo.display(add);

        second.next.next.next.next = second.next;

        Node cycle=linkedListDemo.detectCycle(second);
        if(cycle !=null){
            linkedListDemo.breakCycle(cycle,second);
        }
        linkedListDemo.display(second);
        linkedListDemo.display(first);

        linkedListDemo.reorderLinkedList(first);
        linkedListDemo.display(first);

    }


    public Node addition(Node first, Node second) {
        if(first == null  && second == null)
            return null;
        if(first == null)
            return second;
        if(second == null)
            return first;
        Node firstItr =first, secondItr = second;

        while(firstItr != null && secondItr != null){
            firstItr.val = firstItr.val + secondItr.val;
            Node temp = firstItr;
            System.out.print (firstItr.val +" ");
            while(temp.val >=10){
                temp.val = temp.val%10;
                if(temp.next != null)
                    temp.next.val+=1;
                else
                    temp.next= new Node(1);
                temp= temp.next;
            }
            if(firstItr.next == null &&  secondItr.next != null) {
                firstItr.next = secondItr.next;
                break;
            }else{
                firstItr = firstItr.next;
                secondItr= secondItr.next;
            }
        }
        return first;
    }
    public void display(Node node){
        System.out.println("=================");

        while(node != null){
            System.out.print(node.val +" ");
            node= node.next;
        }
        System.out.println();
    }

    public Node reverseOrder( Node n1, Node n2){
        Stack<Integer> st1= new Stack();
        Stack<Integer> st2 = new Stack();
        while(n1 != null){
            st1.push(n1.val);
            n1= n1.next;
        }
        while( n2 != null){
            st2.push(n2.val);
            n2 = n2.next;
        }
        System.out.println( st1.toString());

        System.out.println( st2.toString());
        int carry =0;
        Node node= new Node(-1);
        Node itr = node;
        while( !st1.isEmpty() || !st2.isEmpty() ){
            int sum = (st1.isEmpty() ? 0: st1.pop()) + (st2.isEmpty()? 0 : st2.pop()) + carry;
                if( itr.val == -1){
                    itr.val = sum%10;
                    carry = sum/10;
                }else{
                    itr.next = new Node(sum%10);
                    carry = sum/10;
                    itr=itr.next;
                }
        }
        if(carry ==1)
            itr.next = new Node(1);
        return node;
    }

    public Node detectCycle( Node node){
        if( node == null)
            return null;
        Node slow = node, fast = node;
        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast=fast.next.next;
            if( slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public void breakCycle( Node cycle, Node node){
        Node itr = node;
        while(cycle != itr ){
            itr = itr.next;
            cycle = cycle.next;
        }
        while( itr.next != cycle){
            itr= itr.next;
        }
        itr.next = null;
    }


    public  void reorderLinkedList( Node node){
        if( node == null || node.next == null )
            return;
        Node slow = node, fast = node;
        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node current = slow.next, prev = null;
        slow.next = null;
        while( current != null ){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Node order = prev, first =node ;
        while(order != null){
            Node firstNext = first.next;
            Node secondNext = order.next;
            first.next = order;
            order.next = firstNext;
            first = firstNext;
            order = secondNext;
        }
    }
}

class Node {
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}