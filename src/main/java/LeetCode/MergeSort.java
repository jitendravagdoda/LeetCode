package LeetCode;


import java.sql.SQLOutput;
import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int array[]={2,6,2,3,10,20,6,8,7,1};
        System.out.println(Arrays.toString(array));
        MergeSort mergeSort=new MergeSort();
        mergeSort.sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int array[], int left, int right){
        if(left<right){
            int mid=(left+right)/2;
            sort(array,left,mid);
            sort(array,mid+1,right);

            helper(array, left,mid,right);
        }
    }

    public void helper(int array[], int left, int mid, int right){

        int leftP=mid-left+1;
        int rightP= right-mid;

        int l[]=new int[leftP];
        int r[]=new int[rightP];

        for(int i=0,j=left; i<leftP; i++){
            l[i]=array[j++];
        }
        for( int i=0, j=mid+1; i<rightP; i++){
            r[i]=array[j++];
        }

        System.out.println(left+" "+mid+" "+right +" "+ Arrays.toString(l)+" "+Arrays.toString(r));

        int k=left,i=0, j=0;
        while(i<leftP && j<rightP){
            if(l[i]<=r[j]){
                array[k++]=l[i++];
            }else{
                array[k++]=r[j++];
            }
        }

        while(i<leftP)
            array[k++]=l[i++];

        while(j<rightP)
            array[k++]=r[j++];


    }
}
