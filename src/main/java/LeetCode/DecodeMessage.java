package LeetCode;

public class DecodeMessage {
    public static void main(String args[]){
        String s="100";
        DecodeMessage decodeMessage=new DecodeMessage();
        System.out.println(decodeMessage.decode(s));
        System.out.println(decodeMessage.decodeWithoutExtraMemory(s));
    }

    public int decode(String s){
        return helper(s,s.length());
    }

    public int helper(String s, int k){

        if(k==1 || k==0) {
            return 1;
        }
        if(s.charAt(0)=='0')
            return 0;
        int remain=s.length()-k;
        return helper(s,k-1) + ((k>=2 && Integer.parseInt(s.substring(remain,remain+2))<=26)? helper(s,k-2):0);
    }

    public  int decodeWithoutExtraMemory( String s){
        if(s.length()==1)
            return 1;

        int dp[]=new int[s.length()+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        for(int i=2; i<dp.length; i++){

         dp[i]+=s.charAt(i-1)=='0'?0:dp[i-1];

         dp[i]+=(Integer.parseInt(s.substring(i-2,i))>=10&& Integer.parseInt(s.substring(i-2,i))<=26)?dp[i-2]:0;

        }

        return dp[s.length()];
    }

}

//
//if (s == null || s.length() == 0) {
//        return 0;
//        }
//        int n = s.length();
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = s.charAt(0) != '0' ? 1 : 0;
//        for (int i = 2; i <= n; i++) {
//        int first = Integer.valueOf(s.substring(i - 1, i));
//        int second = Integer.valueOf(s.substring(i - 2, i));
//        if (first >= 1 && first <= 9) {
//        dp[i] += dp[i-1];
//        }
//        if (second >= 10 && second <= 26) {
//        dp[i] += dp[i-2];
//        }
//        }
//        return dp[n];