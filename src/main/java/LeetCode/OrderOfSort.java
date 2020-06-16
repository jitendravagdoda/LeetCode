package LeetCode;
import sun.jvm.hotspot.memory.PlaceholderEntry;

import java.util.*;

public class OrderOfSort {
    public static void main(String[] args) {

        String words[] = {
        "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
    };
        OrderOfSort orderOfSort=new OrderOfSort();
        System.out.println(orderOfSort.findOrderOfSort(words));
    }

    public String  findOrderOfSort(String words[]){
        if( words != null && words.length == 0) return "";

        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap();

        for(String word : words){
            for(char c: word.toCharArray()){
                degree.putIfAbsent(c, 0);
            }
        }

        String prev = words[0];
        for(int i =1; i<words.length; i++){
            String current = words[i];
            if(prev.length() > current.length() && prev.startsWith(current) )
                return "";
            int j =0;
            for (j = 0; j<Math.min(prev.length(),current.length());j++){
                if( prev.charAt(j) !=  current.charAt(j)){
                    Set<Character> temp=map.getOrDefault(prev.charAt(j),new HashSet<>());
                    temp.add(current.charAt(j));
                    map.put(prev.charAt(j),temp);
                    degree.put(current.charAt(j), degree.get(current.charAt(j))+1);
                    break;
                }
            }
            prev=current;
        }
        Queue<Character> queue = new LinkedList<>();
        for(char c: degree.keySet()){
            if(degree.get(c) == 0)
                queue.add(c);
        }
        String result= "";
        while(!queue.isEmpty()){
            char temp= queue.poll();
            result += temp;
            if(map.containsKey(temp)){
                for(char c: map.get(temp)){
                    degree.put(c, degree.get(c)-1);
                    if(degree.get(c) == 0)  queue.add(c);
                }
            }
        }

        if(result.length() != degree.size()) return  "";
        return result;

//        List<Character> result=new ArrayList();
//        Map<Character,Node> map=new HashMap();
//        for(int i=0; i<words.length-1; i++){
//            int j=0;
//            while(words[i].charAt(j)==words[i+1].charAt(j)) {
//                j++;
//            }
//
//            Node small=map.getOrDefault(words[i].charAt(j),new Node(words[i].charAt(j)));
//            Node big=map.getOrDefault(words[i+1].charAt(j), new Node(words[i+1].charAt(j)));
//            small.outgoingEdge.add(big);
//            big.incomingEdges++;
//            map.put(words[i].charAt(j),small);
//            map.put(words[i+1].charAt(j),big);
//        }
//
//
//        PriorityQueue<Node> heap=new PriorityQueue(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o1.incomingEdges-o2.incomingEdges;
//            }
//        });
//        for(char c:map.keySet()){
//            heap.add(map.get(c));
//        }
//        int heapSize=heap.size();
//        for (int i = 0; i <heapSize ; i++) {
//            Node temp=heap.poll();
//            System.out.println(temp.value );
//
//            for (int j = 0; j <temp.outgoingEdge.size() ; j++) {
//                Node remove=map.get(temp.outgoingEdge.get(j).value);
//                heap.remove(remove);
//                remove.incomingEdges--;
//                heap.add(remove);
//            }
//        }
//        return result;
    }
}

class Node
{
    char value;
    List<Node> outgoingEdge;
    int incomingEdges;

    Node(char value){
        this.value=value;
        outgoingEdge=new ArrayList<Node>();
        incomingEdges=0;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", outgoingEdge=" + outgoingEdge +
                ", incomingEdges=" + incomingEdges +
                '}';
    }
}
