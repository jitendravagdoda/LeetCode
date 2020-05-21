package LeetCode;
import java.util.*;

public class Mininum_Window_SubString {
    public static void main(String[] args) {
    String source="ABUBEDCDEBANCABC", target="ABCD";
    Mininum_Window_SubString mininum_window_subString=new Mininum_Window_SubString();
    System.out.println(mininum_window_subString.miniMumWindow(source,target));
    }
    public String miniMumWindow(String s, String t){

        Set<Character> set=new HashSet();
        Map<Integer,Character> map= new TreeMap<Integer, Character>();
        int i=0,count=0,start=0,min=Integer.MAX_VALUE;
        String result="";

        for(char temp:t.toCharArray()){
            set.add(temp);
        }
        while(i<s.length()){
            char temp=s.charAt(i);
            if(set.contains(temp) && !map.containsValue(temp)){
                count++;
            }
            map.put(i,temp);
            System.out.println(map.toString()+" "+count);
            while(count>=set.size()){
                if(min>map.size()) {
                    min=map.size();
                    result = map.values().toString();
                }
                char rc=map.remove(start++);
                if(set.contains(rc ) && !map.containsValue(rc)){
                    --count;
                }
                System.out.println("after removal "+rc+" "+count);
            }
                i++;

        }

        return result.replaceAll("[^A-Z]","");
    }

}
