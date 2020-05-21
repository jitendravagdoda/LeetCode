package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ClosetSum {
    public static void main(String[] args) {
        int a[]={-1,3,8,2,9,5};
        int b[]={4,1,2,10,5,20};
        ClosetSum closetSum=new ClosetSum();
        int result[]=closetSum.findClosetSumPair(a,b,24);
        System.out.println(Arrays.toString(result));
    }
    public int[] findClosetSumPair(int a[],int b[], int target)
    {
        Arrays.sort(a);
        Arrays.sort(b);

        int result[]=new int[2];

        int diff=Integer.MAX_VALUE;
        int left=0, right=b.length-1;
        while(left<a.length && right>0){
            int temp=a[left]+b[right];
            if(diff>Math.abs(temp-target)){
                diff=Math.abs(temp-target);
                result[0]=a[left];
                result[1]=b[right];
            }
            if(temp-target>0){
                right--;
            }else if(temp-target<0){
                left++;
            }else {
                break;
            }
        }
        return result;
    }
}
