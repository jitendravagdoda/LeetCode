package LeetCode;

import java.util.*;

public class SumOfPair {
    public static void main(String[] args) {
        SumOfPair t=new SumOfPair();
        System.out.println(t.hammingWeight(Long.valueOf(4294967293L)));
        int input[]={23,40,58,87,89,96,45};
        System.out.println("Sum is"+t.maxinumSumPair(input));
    }
    public int hammingWeight(Long l) {

        int count = 0;
        while (l >= 1) {
            if (l % 2 != 0)
                count++;
            l=l/2;
        }
        return l==1? ++count : count;
    }

    public int maxinumSumPair(int a[]){
        Map<Integer,Integer> map=new HashMap();
        int result=-1;

        for(int n:a){
            int sum=pairSum(n);
            if(!map.containsKey(sum)){
                map.put(sum,n);
            }else{
                result=Math.max(result,n+map.get(sum));
                if(n>map.get(sum)){
                    map.put(sum,n);
                }
            }
        }

        return result;
    }
    public int pairSum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }

}

