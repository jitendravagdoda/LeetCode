
import java.util.*;
public class Calculator {
    public static void main(String[] args) {

        Addition addition = (a,b) -> a+b;
        Substraction  substraction = (a, b) -> a-b;


        List<Employee> list = Arrays.asList( new Employee(1,"jitendra",23),
                new Employee(2,"bhavik", 25),
                new Employee(3, "abc",45),
                new Employee(4,"def",56)
        );


        // Employee id name age ;
        list.stream()
                .filter(employee -> employee.age>=54).forEach(employee -> System.out.println(employee));

        System.out.println(list.toString());
        Collections.sort(list, (e1,e2) -> e1.getAge()-e2.getAge());



    }
}
/*
 A1 = 1,2,3 4, 5,6,8,10
 A2 = 2,3,7, 8;

union = 1,2,3,4,5,6,7,8,10
intersaction 2,3,8

   // Intersaction
    new Set(A1)
    ArrayList result;
    for( int nums : A2)
    if(set.contains(nums))
        result.add(nums);

 */

/*
  // Union
  Set.addAll(A1);
  Set.addAll(A2);
 */



interface Addition{
    int add (int a, int b);
}

interface Substraction{
    int sub (int a, int b);
}

interface Multiplication{
    int mul (int a, int b);
}

interface Division{
    int div (int a, int b);
}

class Employee  {
    int id;
    String name;
    int age;


    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class EmployeeCompartor implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}






