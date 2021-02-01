public class Printer {
    public static char symbol = 'A';
    public static Object lock = new Object();


    static class Executor implements Runnable {

        private char current;
        private char next;

        public Executor(char current, char next) {
            this.current = current;
            this.next = next;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        while (current != symbol) {
                            lock.wait();
                        }

                        System.out.print(current);
                        symbol = next;
                        lock.notifyAll();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("SWW", e);
                    }
                }
            }
        }
    }
}



