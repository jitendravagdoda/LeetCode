package LeetCode;
import java.sql.SQLOutput;
import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence=new LongestIncreasingSubsequence();
        int nums[]={10,9,2,5,3,7,1,101,18};
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            // i will contain the Inserttion position in Dp arrays formula (-(insert_position)-1)
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

}
