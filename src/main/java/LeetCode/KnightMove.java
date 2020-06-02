package LeetCode;
import java.util.*;

public class KnightMove {
    public static void main(String[] args) {
        KnightMove km=new KnightMove();
        System.out.println(km.minimumKnightCalculator(4,4));
    }

    public int minimumKnightCalculator(int x, int y){

        if(x==0 && y==0)
            return 0;
        x=Math.abs(x);
        y=Math.abs(y);
        if(x+y==3)
            return 1;

        int dx[]={1,2,1,2,-1,-2,-1,-2};
        int dy[]={2,1,-2,-1,2,1,-2,-1};

        Queue<int[]> queue=new LinkedList();
        Set<String> set=new HashSet();
        queue.add(new int[]{0,0});
        set.add("0,0");
        int result=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size; i++){
                int point[]=queue.poll();
                int cx=point[0];
                int cy=point[1];
                if(cx==x && cy==y)
                    return result;
                for(int j=0; j<dx.length; j++){
                    int newX=cx+dx[j];
                    int newY=cy+dy[j];
                    if(!set.contains(newX+","+newY) &&  newX>=-1 && newY>=-1){
                        queue.add(new int[]{newX,newY});
                        set.add(newX+","+newY);
                    }
                }

            }
            result++;
        }

        return result;
    }
}
