package LeetCode;
import java.util.*;

public class Simplify_Path {
    public static void main(String args[]){
        Simplify_Path simplifyPath=new Simplify_Path();
        System.out.println(simplifyPath.simplifyPath(" /a//b/c//.//"));
    }

    public String simplifyPath(String path) {
        if(path.length()==0)
            return "/";

        LinkedList<String> st=new LinkedList();
        String input[]=path.split("/");

        for(String temp:input){
            if(temp.equals(".") || temp.isEmpty())
                continue;
            else if(temp.equals("..")){
                if(!st.isEmpty())
                    st.pop();
            }else{
                st.add(temp);
            }
            System.out.println(st.toString());
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append("/"+st.removeLast());
        }
        return sb.length()==0?"/": sb.toString();
    }
}