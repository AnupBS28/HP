public class CustomThread_2 extends Thread {
public CustomThread_2(String name) {
super(name);
}
@Override
public void run() {
System.out.println("Executing thread "+Thread.currentThread().getName());
}
public static void main(String[] args) throws InterruptedException {
CustomThread_2 CustomThread_21 = new CustomThread_2("CustomThread_21");
CustomThread_21.start();
CustomThread_2 CustomThread_22 = new CustomThread_2("CustomThread_22");
CustomThread_22.start();
CustomThread_2 CustomThread_23 = new CustomThread_2("CustomThread_23");
CustomThread_23.start();
CustomThread_2 CustomThread_24 = new CustomThread_2("CustomThread_24");
CustomThread_24.start();
CustomThread_2 CustomThread_25 = new CustomThread_2("CustomThread_25");
CustomThread_25.start();
}
}
