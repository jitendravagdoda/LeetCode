package LeetCode;

import java.util.ArrayList;
        import java.util.Collections;
        import java.util.PriorityQueue;
        import java.util.List;

        class Solution {

    List<DistancePostOffice> kClosest(List<DistancePostOffice> restaurants, int k) {
        PriorityQueue heap = new PriorityQueue(k, Collections.reverseOrder());

        for(DistancePostOffice r : restaurants) {
            heap.add(r);
            if(heap.size() == k+1){
                heap.remove();
            }
        }
        return new ArrayList<DistancePostOffice>(heap);
    }
}

    class DistancePostOffice implements Comparable<DistancePostOffice> {
        int x, y;
        DistancePostOffice(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return "[" +
                    "x=" + x +
                    ", y=" + y +
                    ']';
        }

        double distance() {
            return Math.sqrt(x*x + y*y);
        }


        public int compareTo(DistancePostOffice another) {
            return Double.compare(this.distance(), another.distance());
        }
    }

    public class PostOffices {
        public static void main(String[] args) {

            DistancePostOffice r1=new DistancePostOffice(-16,5);
            DistancePostOffice r2=new DistancePostOffice(-1,2);
            DistancePostOffice r3=new DistancePostOffice(4,3);
            DistancePostOffice r4=new DistancePostOffice(10,-2);
            DistancePostOffice r5=new DistancePostOffice(0,3);
            DistancePostOffice r6=new DistancePostOffice(-5,-9);

            List<DistancePostOffice> list=new ArrayList();
            list.add(r1);
            list.add(r2);
            list.add(r3);
            list.add(r4);
            list.add(r5);
            list.add(r6);

            Solution s=new Solution();
            System.out.println(s.kClosest(list,3).toString());

        }
    }
