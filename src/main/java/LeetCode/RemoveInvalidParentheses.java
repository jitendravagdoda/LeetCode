package LeetCode;
import java.util.*;
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        String s="()())(()()()";
        RemoveInvalidParentheses removeInvalidParentheses=new RemoveInvalidParentheses();
        String temp=removeInvalidParentheses.isValidParentheses(s);
        temp=temp.replaceAll("[^0-9]","");

        StringBuilder sb=new StringBuilder();
        int removedChar=0;
        for(int i=0; i<s.length(); i++){

                sb.append(s.charAt(i));

        }
        System.out.println(sb.toString());



    }
    public  Map<Integer, Character> unblanced(String s){
        Stack<Character> st=new Stack();
        Map<Integer,Character> map=new HashMap();
        for(int i=0; i<s.length(); i++){

        }

        return map;
    }
    public String isValidParentheses(String s){
        Stack<Integer> st=new Stack();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(')
                st.push(i);
            else if(st.isEmpty() || s.charAt(st.peek())!='(')
                st.push(i);
            else
                st.pop();
        }
        return st.toString();
    }
}
