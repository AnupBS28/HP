public class MyRunnable_3 implements Runnable {
    public void run() {
    System.out.println("Current executing thread :"+Thread.currentThread().getName());
    }
    public static void main(String[] args) throws InterruptedException {
    Thread myThread = new Thread(new MyRunnable_3(), "I am Thread using Runnable");
    myThread.start();
    }
    }
    