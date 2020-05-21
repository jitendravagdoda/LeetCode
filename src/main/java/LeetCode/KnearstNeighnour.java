package LeetCode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KnearstNeighnour {

    public static void main(String[] args) throws Exception {


        int[][] points={{1,1},{2,2},{2,1},{3,4},{4,1},{-1,-2}};
        System.out.println(points.length+"  "+points[0].length);
        nearstPointCalculator(points,0,0,3);
    }

    static void nearstPointCalculator(int[][] input,int x, int y, int num ){
        int result=0;
        Point[] point=new Point[input.length];
        for(int i=0;i<input.length; i++){
            point[i]=new Point(input[i][0], input[i][1],
                    calculateDistance(input[i][0],input[i][1],x,y));
        }

        PriorityQueue<Point> heap=new PriorityQueue<Point>(num, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return (int)(o1.getDistance()-o2.getDistance());
            }
        });

        for(int i=0;i<point.length;i++)
        {
            if(i<num)
                heap.add(point[i]);
            else{
                if(heap.peek().getDistance()>point[i].getDistance()){
                    heap.poll();
                    heap.add(point[i]);
                }
            }
        }

        for (Point p:heap){
            System.out.println(p.toString());
        }
    }
    static double  calculateDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
}

class Point{
    private int x;
    private int y;
    private double distance;

    Point(){

    }

    Point(int x, int y, double distance){
        this.x=x;
        this.y=y;
        this.distance=distance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", distance=" + distance +
                '}';
    }
}

