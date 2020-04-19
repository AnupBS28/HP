import java.lang.*;
public class exe1    {
public static void main(String[] args) {
long id = Thread.currentThread().getId();
String name = Thread.currentThread().getName();
int priority = Thread.currentThread().getPriority();
Thread.State state = Thread.currentThread().getState();
String threadGroupName = Thread.currentThread().getThreadGroup().getName();
System.out.println("threadid="+id+"; threadname="+name+"; threadpriority="+priority+"; threadstate="+state+"; threadGroupName="+threadGroupName);
}
}