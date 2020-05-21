package LeetCode;

import java.util.LinkedList;


class Cordinate{
    int x;
    int y;
    Cordinate(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "Cordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class  NQueens {
    public static void main(String[] args) {
        NQueens nQueens=new NQueens();
        nQueens.checkNqueen(5);
    }
    public void checkNqueen(int n){


        LinkedList<Cordinate> st=new LinkedList<Cordinate>();
        System.out.println( placeQueen(st,n,0));
        System.out.println("path  "+ st.toString());
    }

    public boolean placeQueen(LinkedList<Cordinate> path, int n, int col){

        if(col==n) return true;
        int row=0;
        while(row<n){
            Cordinate cordinate=new Cordinate(row,col);
            path.add(cordinate);
            System.out.println("after adding "+path.toString());

            if(isSafe(path,row,col) && placeQueen(path,n,++col)){
                return true;
            }
            path.removeLast();
            System.out.println("after removal "+path.toString());
            row++;
        }
        return false;
    }
    public boolean isSafe(LinkedList<Cordinate> path, int row, int col){
        for(int i=0; i<path.size()-1;i++){
            Cordinate temp=path.get(i);
            if(temp.x==row || Math.abs(row-temp.x)==Math.abs(col-temp.y)){
                return false;
            }
        }
        return true;
    }
}
