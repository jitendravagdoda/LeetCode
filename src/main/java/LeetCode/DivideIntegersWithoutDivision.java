package LeetCode;
/*
Given dividend and divisor, return quotient and remainder. Using division or mod operator is not allowed. Do it in better than linear time.

Example:

Input: dividend = 13, divisor = 4
Output: 3, 1
Follow up questions: recursive vs iterative solutions.
 */

public class DivideIntegersWithoutDivision {
    public static void main(String[] args) {
        int dividend = 646435, divisor = 3;
        int low = 1, high = dividend - 1;
        boolean flag = true;
        int mid, mul;
        while (flag) {
            mid = (low + high) / 2;
            mul = divisor * mid;
            if (dividend - mul > 0 && dividend - mul <= divisor) {
                flag = false;
            } else {
                if (mul > dividend) {
                    high = mid;
                    mid = (low + high) / 2;
                } else {
                    low = mid;
                    mid = (low + high) / 2;
                }
                System.out.println(mul);
            }
            System.out.println(mid + " " + (dividend - (mid * divisor)));

            DivideIntegersWithoutDivision divideIntegersWithoutDivision = new DivideIntegersWithoutDivision();
            divideIntegersWithoutDivision.helper(47, 5, 1);
        }
    }
    public void helper(int div, int dis, int quo){
        if(div-dis*quo>0 && div-dis*quo<=dis){
            System.out.println(quo);
            return;
        }else{
            helper(div, dis, quo+1);
        }
    }

}
