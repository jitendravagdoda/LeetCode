package LeetCode;

import java.util.*;

public class QuickSort{
    public static void main(String arg[]){
        int array[]={2, 6, 2, 3, 10, 20, 6, 8, 7, 1};
        System.out.println(Arrays.toString(array));
        QuickSort quickSort=new QuickSort();
        quickSort.sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    public void sort(int nums[], int low, int high){
        if(low<high){
            int pivot=helper(nums,low,high);
            sort(nums,low,pivot-1);
            sort(nums,pivot+1,high);
        }
    }
    public int helper(int nums[], int low, int high){
        int pivot= nums[high];
        int i=low-1;

        for(int j=low; j<high; j++){
            if(nums[j]<pivot){
                i++;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        i++;
        nums[high]=nums[i];
        nums[i]=pivot;
        return i;
    }
}
