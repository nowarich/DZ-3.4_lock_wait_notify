import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static Object lock;
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
            executorService.submit(new Printer.Executor('A', 'B'));
            executorService.submit(new Printer.Executor('B', 'C'));
            executorService.submit(new Printer.Executor('C', 'A'));

            executorService.shutdown();
//        new Thread(new Printer.Executor('A', 'B')).start();
//        new Thread(new Printer.Executor('B', 'C')).start();
//        new Thread(new Printer.Executor('C', 'A')).start();
    }
}
