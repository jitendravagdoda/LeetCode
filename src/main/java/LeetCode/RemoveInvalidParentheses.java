package LeetCode;
import java.util.*;
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        String s="()())(()()()";
        RemoveInvalidParentheses removeInvalidParentheses=new RemoveInvalidParentheses();
        System.out.println(removeInvalidParentheses.helper(s).toString());
    }
    public List<String> helper( String s){
        List<String> result= new ArrayList();
        Set<String> visited= new HashSet();
        Queue<String> queue= new LinkedList();
        visited.add(s);
        queue.add(s);

        while(!queue.isEmpty()){
            String temp = queue.poll();
            if(isValid(temp)){
                result.add(temp);
                break;
            }

            for(int i= 0; i< temp.length(); i++){
                char c = temp.charAt(i);
                if( c != '(' && c != ')') continue;
                String part =  temp.substring(0,i)+temp.substring(i+1);
                if(!visited.contains(part)){
                    visited.add(part);
                    queue.add(part);
                }
            }
        }
        while(!queue.isEmpty()){
            String temp = queue.poll();
            if(isValid(temp))
                result.add(temp);
        }
        return result;
    }

    boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }
}