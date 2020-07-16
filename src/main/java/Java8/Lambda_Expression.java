package Java8;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;
// for practice
import java.util.*;
import java.util.stream.Collectors;

public class Lambda_Expression {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Jitendra","Vagdoda", 29),
                new Person("Bhavik","Vadhia", 28),
                new Person("Bhasker","Yadav", 20),
                new Person("Irfan","Queresh", 41),
                new Person("Pankaj","Tripathi", 35)
        );
        for (int i = 0; i <10 ; i++) {
            System.out.println(fibo(i));
        }

        list.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));

        Collections.sort(list, new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2){
                return p1.getName().compareTo(p2.getName());
            }
        });

        List<Person> people=list.stream().filter( p -> p.getAge()>29).collect(Collectors.toList());

        Addition add = (a,b)->a+b;
        System.out.println(add.add(4,5));
    }

    public static int  fibo(int n) {
        if (n <= 0) return 1;
        else if(n==1) return 1;
        else return fibo(n-1)+ fibo(n-2);
    }
}

interface Addition {
    int add(int a, int b);
}
