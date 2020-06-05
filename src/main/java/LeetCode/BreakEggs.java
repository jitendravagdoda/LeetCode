package LeetCode;

public class BreakEggs {
    public static void main(String[] args) {

        BreakEggs breakEggs=new BreakEggs();
        System.out.println(breakEggs.getMaximumAttempt(2,10));

    }

    public int getMaximumAttempt(int eggs, int floors){

        int dp[][]=new int[eggs+1][floors+1];

        for (int i = 1; i <= eggs; i++)
        {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }


        for(int i=0; i<=floors; i++){
            dp[1][i]=i;
        }
        int c=0;
        for(int e=2; e<=eggs; e++){
            for(int f=2;f<=floors; f++){
                dp[e][f]=Integer.MAX_VALUE;
                for(int k=1; k<=f; k++){
                    c=1+Math.max(dp[e-1][k-1],dp[e][f-k]);
                    if(c<dp[e][f])
                        dp[e][f]=c;
                }
            }
        }

        return dp[eggs][floors];
    }
}
