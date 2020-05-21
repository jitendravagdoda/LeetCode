package LeetCode;

public class DecodeMessage {
    public static void main(String args[]){
        String s="11111";
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
        int first=1, second=1;
        int count=first+second;

        for(int i=2; i<=s.length(); i++){
            count= (s.charAt(i-1)!=0?1:0)*second + (Integer.parseInt(s.substring(i-2,i))<=26?1:0)*first;
            first=second;
            second=count;
        }
        return count;
    }
}
