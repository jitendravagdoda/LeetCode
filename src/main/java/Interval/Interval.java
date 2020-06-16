package Interval;

import java. util.*;
public class Interval {
    public static void main(String[] args) {
        int first[][]={ { 2,5 }, { 1,3 }, { 5,6 }, { 10,12 }, { 8,12 } };
        int second[][]={ { 2,5 }, { 1,3 }, { 5,6 }, { 10,12 }, { 8,12 } };
        Interval interval= new Interval();
        int [][] freeTime=interval.freeTime(first);
        for(int temp[] : freeTime){
            System.out.println(temp[0] +" "+ temp[1]);
        }
        int [][] freeTimeSwapline=interval.freeTimeSwapLine(first);
        for(int temp[] : freeTimeSwapline){
            System.out.println(temp[0] +" "+ temp[1]);
        }

    }
    public int[][] freeTime( int intervals[][]){
        if(intervals.length == 0 || intervals[0].length == 0)
            return new int[][]{};
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int a1[], int b1[]){
                if(a1[0] != b1[0])
                    return a1[0] - b1[0];
                else return  a1[1] - b1[1];
            }
        });

        int prev[] =  new int[2];
        prev[0]= intervals[0][0];
        prev[1]= intervals[0][1];
        List<int []> list= new ArrayList<>();
        for(int i = 1; i<intervals.length; i++){
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if(currentStart <=prev[1]){
                prev[1]= Math.max(currentEnd, prev[1]);
            }else{
                int temp[]={prev[1],currentStart};
                list.add(temp);
                prev[0]= currentStart;
                prev[1]= currentEnd;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public int[][] freeTimeSwapLine(int intevals[][]){
        Map<Integer, Integer> map = new TreeMap();
        for( int interval[]: intevals){
            map.put(interval[0], map.getOrDefault(interval[0],0)+1);
            map.put(interval[1], map.getOrDefault(interval[1],0)-1);
        }
        System.out.println("====map=====");
        System.out.println(map.toString());
        List<int []> list = new ArrayList();
        int start =-1, score =0;
        for(int key:map.keySet()){
            score+= map.get(key);
            if(start == -1 && score == 0)
                start = key;
            else if(start !=-1 && score !=0){
                list.add(new int[]{start, key});
                start = -1;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
    public int[][] mergeInterval( int intervals[][]){
        if(intervals.length == 0 || intervals[0].length == 0)
            return new int[][]{};
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int a1[], int b1[]){
                if(a1[0] != b1[0])
                    return a1[0] - b1[0];
                else return  a1[1] - b1[1];
            }
        });

        int prev[] =  new int[2];
        prev[0]= intervals[0][0];
        prev[1]= intervals[0][1];

        List<int []> result = new ArrayList<>();

        for( int i = 1; i<intervals.length; i++){
        }
        return new int[][]{};
    }
}
