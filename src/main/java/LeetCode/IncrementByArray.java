package LeetCode;
import java.util.*;

public class IncrementByArray {
    public static void main(String args[]){
        int input[]={1,1,2,1,1,2,3,0,1};
        int array[][]={{0,2},{1,7},{2,3},{7,8}};
        IncrementByArray incrementByArray=new IncrementByArray();
        incrementByArray.helper(input,array);
        System.out.println(Arrays.toString(input));
    }
    public void helper(int input[], int array[][]){

        int temp[]=new int[input.length];
        for(int i=0; i<array.length; i++){
            if(array[i][0]<temp.length)
                temp[array[i][0]]++;
            if(array[i][1]<temp.length-1)
                temp[array[i][1]+1]--;
        }
        for(int i=1; i<temp.length; i++){
            temp[i]+=temp[i-1];
        }
        for(int i=0; i<temp.length; i++){
            input[i]+=temp[i];
        }
    }
}
