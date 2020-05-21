package DemoCollections;

import java.util.*;

public class LinkedListDemo {
    public static void main(String args[]){
        List<Integer> list=new LinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        ((LinkedList<Integer>) list).addFirst(-1);
        ((LinkedList<Integer>) list).addLast(5);
        System.out.println(list.toString());
        System.out.println(((LinkedList<Integer>) list).removeFirst());
        System.out.println(((LinkedList<Integer>) list).removeLast());
        System.out.println(((LinkedList<Integer>) list).remove());
        System.out.println(((LinkedList<Integer>) list).offerFirst(6));
        System.out.println(list.toString());
        System.out.println(((LinkedList<Integer>) list).peekLast());
        ((LinkedList<Integer>) list).addLast(2);

    }
}
