package LeetCode;

import java.util.Collections;
import java.util.Stack;

public class Largest_Rectangle_Histogram {
    public static void main(String[] args) {
        int[] input={0,3,4,0,4};
        Largest_Rectangle_Histogram   largest_rectangle_histogram=new Largest_Rectangle_Histogram();
        System.out.println(largest_rectangle_histogram.calculate(input));

    }
    public int calculate(int input[]){

        Stack<Integer> st=new Stack();
        int i=0;
        int result=0;
        while(i<input.length){
            if( st.isEmpty() || input[st.peek()]<=input[i]){
                st.push(i);
                i++;
            }else{
                int currentmax=st.pop();
                result= Math.max(result,input[currentmax] *(st.isEmpty()?(i-1):(i-1-st.peek())));
            }
        }
        while(!st.isEmpty()){
            int currentmax=st.pop();
            result= Math.max(result,input[currentmax] *(st.isEmpty()?(i-1):(i-1-st.peek())));
        }
        return result;
    }
}
