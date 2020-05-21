package LeetCode;

import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;

public class BoxStacking {
    public static void main(String[] args) {
        BoxStacking bs=new BoxStacking();
        Box b[]=new Box[2];
        b[0]=new Box(5,2,3);
        b[1]=new Box(4,2,5);
        int max=bs.maximumHeight(b);
        System.out.println(max);

    }
    public int maximumHeight(Box b[]){

        Box allRotation[]=new Box[b.length*3];
        allRotations(b,allRotation);
        Arrays.sort(allRotation);

        int height[]=new int[allRotation.length];
        int result[]=new int[allRotation.length];

        for(int i=0; i<allRotation.length; i++){
            height[i]=allRotation[i].height;
            result[i]=i;
        }

        int max=Integer.MIN_VALUE;
        for(int i=1; i<allRotation.length; i++){
            for(int j=0;j<i; j++){
                if(allRotation[j].length > allRotation[i].length && allRotation[j].width >allRotation[i].width){
                    if(height[i] < height[j]+allRotation[i].height) {
                        height[i] = height[j] + allRotation[i].height;
                        result[i]=j;
                        max=Math.max(max,height[i]);
                    }
                }
            }
        }

        return max;
    }

    public void  allRotations(Box box[],Box allRotations[]){

        int index=0;
        for(int i=0;i<box.length; i++){
            allRotations[index++]=box[i].createBox(box[i].length,box[i].width, box[i].height);
            allRotations[index++]=box[i].createBox(box[i].width,box[i].height, box[i].length);
            allRotations[index++]=box[i].createBox(box[i].height,box[i].length, box[i].width);
        }
    }
}

class Box implements Comparable<Box> {
     int length;
     int width;
     int height;


    Box(int length, int width, int height){
        this.length=length;
        this.width=width;
        this.height=height;
    }

    public Box createBox(int height, int side1, int side2){

        Box b;
        if(side2>side1)
            b=new Box(side2,side1,height);
        else
            b= new Box(side1,side2,height);

        return b;
    }

    @Override
    public String toString() {
        return "Box{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}'+"\n";
    }

    @Override
    public int compareTo(Box o) {
        return o.length*o.width-this.length*this.width;
    }
}
