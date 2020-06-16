package LeetCode;



public class FirstDuplicate {
    public static void main(String[] args) {
        int nums[] ={1,2,1,2};
        FirstDuplicate duplicate= new FirstDuplicate();
        System.out.println( duplicate.firstDuplicate(nums));
    }

    public  int firstDuplicate( int nums[]){
        if( nums.length == 0)
            return -1;

        for( int i=0;  i<nums.length;  i++){
            if(nums[Math.abs(nums[i]) -1] <0)
                return Math.abs(nums[i]);
            else
                nums[Math.abs(nums[i] )-1]= 0- nums[Math.abs(nums[i] -1)];
        }
        return -1;
    }
}
