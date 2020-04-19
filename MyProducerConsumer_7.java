import java.util.*;

public class MyProducerConsumer_7{
   public static final Queue<Integer> Q = new LinkedList<Integer>(); 
    public static class Consumer implements Runnable {
        public void run() {
            int i=0;
            while(i<10000){
                
                i++;
                synchronized(Q){
                   
                   try{
                    Q.wait();
                   } 
                   catch(InterruptedException e){
                    e.printStackTrace();
                }

                }
                try{
                    Thread.sleep(80);

                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                if(!Q.isEmpty()){
                    Integer k = Q.poll();
                    System.out.println("[" + Thread.currentThread().getName() + "]: " + k);
                }

                


            }

        }
    }
    public static class Producer implements Runnable {
        public void run() {
            int i=0;
            while(i<10000){
                Q.add(i);
                i++;
                synchronized(Q){
                    Q.notify();
                }
                try{
                    Thread.sleep(80);

                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }

                


            }
            synchronized(Q){
                  Q.notifyAll();  
            }
        }
    }
  


    public static void main(String[] args) throws InterruptedException {
        Thread[] consumerThreads = new Thread[1];
        for (int i = 0; i < consumerThreads.length; i++) {

            consumerThreads[i] = new Thread(new Consumer(), "consumer-" + i);

            consumerThreads[i].start();

        }
        Thread producerThread = new Thread(new Producer(), "producer");

        producerThread.start();
        for (int i = 0; i < consumerThreads.length; i++) {

            consumerThreads[i].join();

        }
        producerThread.join();
    }
}