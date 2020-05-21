package LeetCode;
import java.util.*;

public class QueueUsingTwoStack {
    public static void main(String[] args) {

        QueueDemo queue=new QueueDemo();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.remove());
        queue.add(3);
        queue.add(4);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.add(5);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}

class QueueDemo {
    Stack<Integer> enqueue;
    Stack<Integer> dequeue;

    QueueDemo() {
        enqueue = new Stack();
        dequeue = new Stack();
    }

    public void add(int nums) {
        if (dequeue.isEmpty()) {
            enqueue.push(nums);
        } else {
            while (!dequeue.isEmpty()) enqueue.push(dequeue.pop());
            enqueue.push(nums);
        }
    }

    public int remove() {
        if (!dequeue.isEmpty()) {
            return dequeue.pop();
        } else {
            while (!enqueue.isEmpty()) dequeue.add(enqueue.pop());
            return dequeue.pop();
        }

    }
}
