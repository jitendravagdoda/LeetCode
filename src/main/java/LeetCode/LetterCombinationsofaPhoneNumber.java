package LeetCode;
import java.util.*;
public class LetterCombinationsofaPhoneNumber {
    public static void main(String args[]){
        LetterCombinationsofaPhoneNumber letterCombinationsofaPhoneNumber=new LetterCombinationsofaPhoneNumber();
        System.out.println(letterCombinationsofaPhoneNumber.helper("237"));

    }
    public List<String> helper(String digits){
        if(digits.length()==0)
            return new ArrayList<>();

        String numberMap[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> result=new LinkedList();
        result.add("");
        for(int i=0; i<digits.length(); i++){
            String temp=numberMap[digits.charAt(i)-'0'];
            int size=result.size();
            while(size>0){
                String res=result.poll();
                size--;
                for(char c:temp.toCharArray()) {
                    result.add(res + c);
                }
            }
        }
        return result;
    }
}
