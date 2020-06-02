package LeetCode;

public class GetMaximumNumberInsertingDigit {
    public static void main(String[] args) {
        int num=-276;
        GetMaximumNumberInsertingDigit getMaximumNumberInsertingDigit=new GetMaximumNumberInsertingDigit();
        System.out.println(getMaximumNumberInsertingDigit.getMaximum(num,5));
    }
    public int getMaximum(int num, int digit){
        if(num==0)
            return digit*10;
        int maxVal=Integer.MIN_VALUE;
        boolean flag=false;
        if(num<0){
            flag=true;
            maxVal=Integer.MAX_VALUE;
        }
        num=Math.abs(num);
        int count=0, position=1;
        int n=num;
        while(n>0){
            count++;
            n=n/10;
        }
        for(int i=0; i<=count; i++){
            int newVal= (num/position)*(position*10) + digit*position + num%position;

            if(!flag)
                maxVal=Math.max(maxVal,newVal);
            else
                maxVal=Math.min(maxVal,newVal);

            position=position*10;
        }
        return flag?0-maxVal:maxVal;
    }
}
