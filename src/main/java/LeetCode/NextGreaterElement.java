package LeetCode;
import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums={9,1,4,3,6,7,2,8,1};
        NextGreaterElement nextGreaterElement=new NextGreaterElement();
        nextGreaterElement.nextElemet(nums);
    }
    public void nextElemet(int nums[]){
        Stack<Integer>  stack=new Stack();
        for(int i=0;i<nums.length; i++){
            while(!stack.empty() && stack.peek()<nums[i]){
                System.out.println( stack.pop() +" -> "+ nums[i]);
            }
            stack.add(nums[i]);
        }
        while(!stack.empty()){
            System.out.println(stack.pop() +" -> -1");
        }
    }
}
