import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int threadCount = 4;
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < threadCount; ++i) {
            Callable<Integer> callable = new MyCallable();
            tasks.add(callable);
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
        List<Future<Integer>> invokeAll = threadPool.invokeAll(tasks);

        for (int i = 0; i < threadCount; ++i) {
            System.out.printf("Поток №%d вернул %d%n", i + 1, invokeAll.get(i).get());
        }
        threadPool.shutdown();

    }

}
