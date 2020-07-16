package LeetCode;

import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        Permutation p = new Permutation();
        int result[]=p.spacedPermutation(8);
        System.out.println(Arrays.toString(result));
    }
    public int[] spacedPermutation(int n) {
        int[] res = new int[2 * n];
        boolean b = spacedPermutation(n, 1, res);
        return b ? res : new int[0];
    }
    private boolean spacedPermutation(int targetNumber, int currNumber, int[] res) {
        if(currNumber > targetNumber) return true;
        for(int i = 0; i < res.length - currNumber - 1; i++) {
            if(res[i] == 0 && res[i + currNumber + 1] == 0) {
                res[i] = res[i + currNumber + 1] = currNumber;
                boolean b = spacedPermutation(targetNumber, currNumber + 1, res);
                if(b) return true;
                res[i] = res[i + currNumber + 1] = 0;
            }
        }
        return false;
    }
}


