package LeetCode;

public class SubSetOfArray {
    public static void main(String arg[]){
        int nums[]={1,2,3,4,5};
        int k=6;
        SubSetOfArray subSetOfArray=new SubSetOfArray();
        System.out.println(subSetOfArray.findSubSet(nums,k));
        System.out.println(subSetOfArray.countSubsets(nums,k));
        System.out.println(subSetOfArray.subsets(nums,k));

    }
    public int findSubSet(int nums[], int k){
        int count=0;
        int left =0;
        int right=nums.length-1;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum==k){
                count+=Math.pow(2,(right-left)-1);
                left++;
                right--;
                continue;
            }
            if(sum>k)
                right--;
            else
                left++;

        }
        return count;
    }

    public  int subsets(int[]arr, int k) {

        int count = 0;
        int i = 0;

        while (i < arr.length && arr[i] < k) {
            int min = arr[i];
            int j = i + 1;
            while (j < arr.length && arr[j] + min != k) {
                j++;
            }
            if (j < arr.length) {
                count += 1 + j - i > 0? (int)Math.pow(2, j - i - 1): 0;
            }
            i++;
        }

        return count;
    }

    public int countSubsets(int[] nums, int k) {
        int countEqual = 0;
        for (int lo = 0, hi = nums.length - 1; lo <= hi; ) {
            if (nums[lo] + nums[hi] > k) {
                hi--;
            } else {
                if (nums[lo] + nums[hi] == k) {
                    countEqual = countEqual + (1 << (hi - lo - 1));
                }
                lo++;
            }
        }
        return countEqual;
    }
}
