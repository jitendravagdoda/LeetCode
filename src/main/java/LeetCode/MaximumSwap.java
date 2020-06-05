package LeetCode;

import java.util.*;

public class MaximumSwap {
    public static void main(String[] args) {

           int num=9967;
            char[] A = Integer.toString(num).toCharArray();
            int[] last = new int[10];
            for (int i = 0; i < A.length; i++) {
                last[A[i] - '0'] = i;
            }

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(last));
            for (int i = 0; i < A.length; i++) {
                for (int d = 9; d > A[i] - '0'; d--) {
                    System.out.println(d);
                    if (last[d] > i) {
                        char tmp = A[i];
                        A[i] = A[last[d]];
                        A[last[d]] = tmp;
                        System.out.println( Integer.valueOf(new String(A)));
                        return;
                    }
                }
            }
            System.out.println(num);
    }
}
