package LeetCode;
import java.util.*;

public class Subset {
    public static void main(String[] args) {
        int nums[]={1,3,4,5};

        System.out.println(Subset.helper(nums).toString());

    }

    public static List<List<Integer>>  helper(int nums[]){
        List<List<Integer>> result=new ArrayList();
        if(nums.length==0)
            return result;
        result.add(new ArrayList());

        for(int num:nums){
            int size=result.size();
            for(int i=0; i<size; i++){
                List<Integer> list=new ArrayList(result.get(i));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }
}
