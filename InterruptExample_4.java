public class InterruptExample_4 implements Runnable {
public void run() {
try {
Thread.sleep(Long.MAX_VALUE);
} catch (InterruptedException e) {
System.out.println("["+Thread.currentThread().getName()+"]Interrupted by exception!");
}
while(!Thread.interrupted()) {

}
System.out.println("["+Thread.currentThread().getName()+"]Interrupted for the second time.");
}
public static void main(String[] args) throws InterruptedException {
Thread myThread = new Thread(new InterruptExample_4(), "myThread");
myThread.start();
System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 6s...");
Thread.sleep(6000);
System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread");
myThread.interrupt();
System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 6s...");
Thread.sleep(6000);
System.out.println("["+Thread.currentThread().getName()+"]Interrupting myThread");
myThread.interrupt();
}
}
