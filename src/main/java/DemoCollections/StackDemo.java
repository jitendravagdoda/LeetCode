package DemoCollections;
import java.util.*;

public class StackDemo {
    public static void main(String args[]){
        StackMinNumber st=new StackMinNumber();
        st.push(12);
        st.push(13);
        st.push(1);
        System.out.println(st.getMin());
        System.out.println(st.stack.peek());

        System.out.println(st.stack.toString());
        System.out.println(st.pop());
        System.out.println(st.getMin());
        System.out.println(st.pop());

    }
}

class StackMinNumber{
    Stack<Integer> stack;
    int min;
    StackMinNumber(){
        stack=new Stack();
        min=Integer.MAX_VALUE;
    }
    public void push(int x){
        if(stack.isEmpty()){
            min=x;
            stack.push(x);
        }else{
            if(x<min){
                stack.push(x-min);
                min=x;
            }else
                stack.push(x);
        }
    }
    public int pop(){
        int temp= stack.pop(),result=min;
        if(temp<min){
            min=min-temp;
            return result;
        }else{
            return temp;
        }
    }
    public int getMin(){
        return stack.isEmpty()?Integer.MAX_VALUE:min;
    }
}
