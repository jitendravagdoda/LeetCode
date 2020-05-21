package LeetCode;

import java.util.*;
import java.util.Queue;

public class Treasure {

    public static void main(String[] args) {

        char[][] input = {
                {
                    'O', 'O', 'D', '0','0'
                },
                {
                    'D', '0', '0', '0','0'
                },
                {
                    '0', '0', 'D', '0','0'
                },
                {
                    '0', '0', '0', '0','X'
                }
        };

        //System.out.println(input.length);

        System.out.println(helper(input));
    }

    public static int helper(char[][] input) {

        int row = input.length;
        int cols = input[0].length;

        boolean[][] isVisited = new boolean[row][cols];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0, 0, 0});
        isVisited[0][0] = true;
        int ans = Integer.MAX_VALUE;

        while(!q.isEmpty()) {

            int[] current = q.poll();

            int currentX = current[0];
            int currentY = current[1];
            int currentDis = current[2];

            //System.out.println(currentX + "==" + currentY);

            if(input[currentX][currentY] == 'X') {
                ans = Math.min(ans, currentDis);
            }

            for(int i=0; i < dx.length; i++) {

                int newX = currentX + dx[i];
                int newY = currentY + dy[i];
                int distance = currentDis + 1;

                //System.out.println(newX + "==" + newY);

                if(isValid(input, newX, newY) && !isVisited[newX][newY]) {
                    //System.out.println("==" + newX + "==" + newY);
                    q.add(new int[]{newX, newY, distance});
                    isVisited[newX][newY] = true;
                }
            }
        }

        return ans==Integer.MIN_VALUE? -1:ans;
    }

    public static boolean isValid(char[][] input, int row, int col) {



        if(row < 0 || row >= input.length || col < 0 || col >= input[0].length || input[row][col] == 'D') {
            return false;
        }

        return true;
    }
}
