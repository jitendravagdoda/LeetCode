package LeetCode;
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
        orderOfSort.findOrderOfSort(words);
    }

    public List<Character> findOrderOfSort(String words[]){
        List<Character> result=new ArrayList();
        Map<Character,Node> map=new HashMap();
        for(int i=0; i<words.length-1; i++){
            int j=0;
            while(words[i].charAt(j)==words[i+1].charAt(j)) {
                j++;
            }

            Node small=map.getOrDefault(words[i].charAt(j),new Node(words[i].charAt(j)));
            Node big=map.getOrDefault(words[i+1].charAt(j), new Node(words[i+1].charAt(j)));
            small.outgoingEdge.add(big);
            big.incomingEdges++;
            map.put(words[i].charAt(j),small);
            map.put(words[i+1].charAt(j),big);
        }


        PriorityQueue<Node> heap=new PriorityQueue(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.incomingEdges-o2.incomingEdges;
            }
        });
        for(char c:map.keySet()){
            heap.add(map.get(c));
        }
        int heapSize=heap.size();
        for (int i = 0; i <heapSize ; i++) {
            Node temp=heap.poll();
            System.out.println(temp.value );
            for (int j = 0; j <temp.outgoingEdge.size() ; j++) {
                temp.outgoingEdge.get(j).incomingEdges--;
            }
        }
        return result;
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
