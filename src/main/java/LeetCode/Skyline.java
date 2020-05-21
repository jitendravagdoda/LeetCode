package LeetCode;
import java.util.*;

public class Skyline {
    public static void main(String args[]){
        int [][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};
        Skyline skyLine=new Skyline();
        skyLine.skyLinePoints(buildings);
    }

    public List< int[] > skyLinePoints(int building[][]){
        List<int[]> list=new ArrayList();
       // BuildingPoint[] buildingPoints=new BuildingPoint[2*building.length];
        PriorityQueue<BuildingPoint> queue=new PriorityQueue();
        for(int i=0,j=0;i<building.length;i++){
            queue.add(new BuildingPoint(building[i][0],true,building[i][2]));
            queue.add(new BuildingPoint(building[i][1],false,building[i][2]));
        }
        System.out.println(queue.toString());

        return list;
    }
}


class BuildingPoint implements Comparator<BuildingPoint>{
    int x;
    boolean isStart;
    int height;
    BuildingPoint(int x,boolean isStart,int height){
        this.x=x;
        this.isStart=isStart;
        this.height=height;
    }
    @Override
    public int compare(BuildingPoint b1, BuildingPoint b2){
        if(b1.x!=b2.x) return b1.x-b2.x;
        else return (b1.isStart? b1.x: -b1.x)-(b2.isStart? b2.x:-b2.x);
    }

    @Override
    public String toString() {
        return "BuildingPoint{" +
                "x=" + x +
                ", isStart=" + isStart +
                ", height=" + height +
                '}';
    }
}
