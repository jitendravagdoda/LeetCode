package LeetCode;

import java.util.*;

public class MaxHeap {
    public static void main(String[] args) {
        int nums[]={1,2,3,4,5,6,7,7,8,8,99,99,1,21,4,5,2,100,67};

        ArrayList<Integer> arrayList=new ArrayList<Integer>();

        StringBuilder sb=new StringBuilder("Hello hi test");
        sb.reverse();
        System.out.println(sb.toString());

        Student s1=new Student("b",20);
        Student s2=new Student("a",19);
        Student s3=new Student("d",18);
        Student s4=new Student("c",121);

//
//        PriorityQueue<Student> num=new PriorityQueue( new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.name.compareTo(s2.name);
//            }
//        });

        System.out.println("d".compareTo("c"));


        PriorityQueue<Student> students=new PriorityQueue(new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2) {
              int namecompare =s1.name.compareTo(s2.name);
              int idcompare=s1.id-s2.id;
              if(namecompare==0){
                  return idcompare;
              }
              return namecompare;
            }
        });

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        System.out.println(students.toString());

        for (Student s:students){
            System.out.println(s.toString());
        }

    }
}

class Student  {
    String name;

    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}




