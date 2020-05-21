
package LeetCode;

import java.util.*;

import static junit.framework.Assert.assertEquals;

public class Partition_Labels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        Partition_Labels pl=new Partition_Labels();
        assertEquals(Arrays.asList(9, 7, 8),pl.calculate(s));
    }

//    public List<Integer>  calculate(String input){
//        List<Integer> result=new ArrayList();
//        int last[]=new int[26];
//        for(int i=0; i<input.length(); i++){
//            last[input.charAt(i)-'a']=i;
//        }
//        int start=0;
//        int j=Integer.MIN_VALUE;
//        for(int i=0;i<input.length();i++){
//            j=Math.max(j,last[input.charAt(i)-'a']);
//            if(i==j){
//                result.add(i-start+1);
//                start=i+1;
//            }
//        }
//        return result;
//    }

    public List<Integer> calculate(String s){
        List<Integer> result=new ArrayList();

        int lastIndex[]=new int[26];
        for (int i=0;i<s.length(); i++){
            lastIndex[s.charAt(i)-'a']=i;
        }

        int start=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length(); i++){
            max=Math.max(max,lastIndex[s.charAt(i)-'a']);
            if(i==max){
                result.add(i-start+1
                );
                start=i+1;
                max=Integer.MIN_VALUE;
            }
        }

        return result;
    }
}

