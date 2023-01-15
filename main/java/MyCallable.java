import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable extends Thread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random r = new Random();
        int count = r.nextInt(5);
        for(int i=0; i<count; ++i) {
            Thread.sleep(1000);
            System.out.println("Я поток "+Thread.currentThread().getName()+". Привет!");
        }
        return  count;
    }
}
