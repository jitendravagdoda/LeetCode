import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

import java.util.concurrent.Callable;

public class ThreadDemo {
    public static void main(String[] args) {

        String s = "helloD";
        s=s.replaceAll("hell[^a-z]D","");
        System.out.println(s);

    }
}

 class Solution implements  Runnable, Callable {
    @Override
    public void run(){
        System.out.println("");
    }

     @Override
     public Object call() throws Exception {
         return null;
     }
 }