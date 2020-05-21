package LeetCode;

import java.util.*;

public class SubStringSearch {
    public static void main(String[] args) {
        String text= "abcdbcglbx";
        String pattern= "bcdgd  ";
        System.out.println(new SubStringSearch().subStringSearch(text.toCharArray(),pattern.toCharArray()));

        Map<Integer, Integer>  map =new HashMap<Integer, Integer>();

    }

    public boolean subStringSearch(char text[],char pattern[]){
        if(text==null || pattern==null || text.length==0 || pattern.length> text.length)
            return false;


        int[] patternArray=computeArray(pattern);
        int textLenth=text.length;
        int patternLength=pattern.length;
        int i=0,j=0;
        while(i<textLenth){
            if(j==patternLength-1)
                return true;
            if(text[i]==pattern[j]){
                i++;
                j++;
            }else{
                if(j==0){
                    i++;
                }else{
                    j=patternArray[j-1];
                }
            }

        }
        return false;
    }

    public int[] computeArray(char pattern[]){
        int[] result=new int[pattern.length];
        int index=0;

        for(int i=1;i<pattern.length; ){
            if(pattern[i]==pattern[index]){
                result[i]=index+1;
                index++;
                i++;
            }else{
                if(index==0){
                    result[i]=index;
                    i++;
                }else{
                    index=result[index-1];
                }
            }
        }
        return result;
    }
}
