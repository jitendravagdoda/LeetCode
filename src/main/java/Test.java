
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws Exception{



        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = executorService.submit(new Task());
            list.add(future);
        }
        int count = 0, i = 0;
        while (count < 10) {
            if (list.get(i).isDone()) {
                System.out.println(list.get(i).get());
                count++;
            } else {
                i++;
                if (i >= 10) {
                    i = 0;
                }
            }
        }
    }
}


class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return new Random().nextInt();
    }
}

