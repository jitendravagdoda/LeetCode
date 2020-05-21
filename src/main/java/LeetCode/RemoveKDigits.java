package LeetCode;
import java.util.*;

public class RemoveKDigits {
    public static void main(String[] args) {

        String number="991989";
        int k=4;
        System.out.println(removeKdigits(number,k));

    }
//    static String removeKdigits(String num, int k){
//
//        LinkedList<Character> stack=new LinkedList();
//        for(int i=0; i<num.length(); i++){
//            while(!stack.isEmpty() && stack.peek()>num.charAt(i) && k>0){
//                stack.pop();
//                k--;
//            }
//            stack.push(num.charAt(i));
//            System.out.println(stack.toString());
//
//        }
//
//        while(k!=0){
//            stack.pop();
//            k--;
//        }
//        while(stack.peekLast()=='0'){
//            stack.removeLast();
//        }
//        StringBuilder stringBuilder=new StringBuilder();
//        while (!stack.isEmpty()){
//            stringBuilder.append(stack.removeLast());
//        }
//        return stringBuilder.length() == 0? "0" : stringBuilder.toString();
//    }

    static String removeKdigits(String s, int k ){

        LinkedList<Character> stack=new LinkedList();

        for(int i=0; i<s.length(); i++){
            while(!stack.isEmpty() && stack.peek()>s.charAt(i) && k>0){
                stack.pop();
                k--;
            }
            stack.push(s.charAt(i));
        }
        while(k>0){
            stack.pop();
            k--;
        }
        while(stack.peekLast()=='0'){
            stack.removeLast();
        }
        StringBuilder stringBuilder= new StringBuilder();

        while(!stack.isEmpty()){
            stringBuilder.append(stack.removeLast());
        }

        return stringBuilder.length()==0? "0": stringBuilder.toString();
    }
}
