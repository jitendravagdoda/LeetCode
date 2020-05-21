package LeetCode;

public class Median {
    public static void main(String[] args) {
        int input1[]={1,3,6,9,10,12};
        int input2[]={2,4,5,7,8,11};
        medianCalculate(input1,input2);
    }

    public static void medianCalculate(int input1[],int input2[]){

        if(input1.length>input2.length){
            medianCalculate(input2,input1);
        }
        int x=input1.length;
        int y=input2.length;
        int low=0,high=x;
        int partionX,partionY;
        while(low<high){
            partionX=(low+high)/2;
            partionY=(x+y+1)/2-partionX;

            int maxLeftX=(partionX==0)? Integer.MIN_VALUE:input1[partionX-1];
            int minRightX=(partionX==x)? Integer.MAX_VALUE:input1[partionX];

            int maxLeftY= partionY==0? Integer.MIN_VALUE:input2[partionY-1];
            int minRightY= partionY==y? Integer.MAX_VALUE:input2[partionY];

            if(maxLeftX<=minRightY && maxLeftX>=maxLeftY){
                if((x+y)%2==0){
                    System.out.println((double) (Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2);
                    return;
                }else{
                    System.out.println(Math.max(maxLeftX,maxLeftY));
                    return;
                }
            }else{
                if(maxLeftX>minRightY){
                    high=partionX;
                }else{
                    low=partionX-1;
                }

            }

        }

    }

    }



