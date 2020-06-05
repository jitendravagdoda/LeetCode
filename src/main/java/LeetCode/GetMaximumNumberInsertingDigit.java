package LeetCode;

public class GetMaximumNumberInsertingDigit {
    public static void main(String[] args) {
        int num=276;
        GetMaximumNumberInsertingDigit getMaximumNumberInsertingDigit=new GetMaximumNumberInsertingDigit();
        System.out.println(getMaximumNumberInsertingDigit.getMaximum(num,5));
    }
    public int getMaximum(int num, int digit){
        if(num==0)
            return digit*10;
        int maxVal=Integer.MIN_VALUE;
        int flag=1;
        if(num<0){
            flag=-1;
        }
        num=Math.abs(num);
        int count=0, position=1;
        int n=num;
        while(n>0){
            n=n/10;
            int newVal= (num/position)*(position*10) + digit*position + num%position;
            maxVal=Math.max(maxVal,newVal*flag);
            position=position*10;

        }
        for(int i=0; i<=count; i++){
            int newVal= (num/position)*(position*10) + digit*position + num%position;
            maxVal=Math.max(maxVal,newVal*flag);
            position=position*10;
        }
        return maxVal;
    }
}
