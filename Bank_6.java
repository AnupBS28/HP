class MyBank {
   public double balance;
   public MyBank(double bal) { balance = bal; }
   
   
}

class ProducerWithoutSynchronisation extends Thread {
   private MyBank acc;
   public ProducerWithoutSynchronisation(MyBank acct) { acc = acct; }
   public void run() {
   System.out.println("Balance before depositing " + acc.balance);
   acc.balance=acc.balance+10; 
   System.out.println("Balance after depositing " + acc.balance);
  
   }
}
class ConsumerWithoutSynchronisation extends Thread {
   private MyBank acc;
   public ConsumerWithoutSynchronisation(MyBank acct) { acc = acct; }
   public void run() {
      
     
   System.out.println("Balance  before withdrawing " + acc.balance);
   if(acc.balance>10) {acc.balance=acc.balance-10;} 

   System.out.println("Balance after withdrawing " + acc.balance);

   }
}



class ProducerWithSynchronisation extends Thread {
   private MyBank acc;
   public ProducerWithSynchronisation(MyBank acct) { acc = acct; }
   public void run() {
   System.out.println("before deposit balance " + acc.balance);
   synchronized(acc) { acc.balance=acc.balance+10; }
   System.out.println("after deposit balance " + acc.balance);
  
   }
}



class ConsumerWithSynchronisation extends Thread {
   private MyBank acc;
   public ConsumerWithSynchronisation(MyBank acct) { acc = acct; }
   public void run() {
      
     
   System.out.println("before withdraw balance " + acc.balance);
   synchronized(acc) {if(acc.balance>10) {acc.balance=acc.balance-10;} }

   System.out.println("after withdraw balance " + acc.balance);

   }
}

public class Bank_6 {
   public static void main(String[] args) {
      MyBank acc;// = new MyBank(100);
      int j=0;
      while(j<2){
         j++;
         acc = new MyBank(500);
         int threadCount = 11;

         if(j%2!=0)
            System.out.println("output without any synchronisation between threads: ");
            else
            System.out.println("output with synchronisation between threads:");
   
         System.out.println();
   
         Thread[] threads = new Thread[threadCount];
         for(int i = 0; i < threadCount; i++) {
            if (i % 2 == 0) {
               if(j%2!=0)
               threads[i] = new ProducerWithoutSynchronisation(acc);
               else{
                  threads[i] = new ProducerWithSynchronisation(acc);
               }
            } else {
               if(j%2!=0)
               threads[i] = new ConsumerWithoutSynchronisation(acc);
               else
               threads[i] = new ConsumerWithSynchronisation(acc);
            }
         }
         for(int i = 0; i < threadCount; i++) {
            threads[i].start();
         }
         for(int i = 0; i < threadCount; i++) {
               try {
               threads[i].join();
            } catch(InterruptedException ie) {
                  System.err.println(ie.getMessage());
                              
            }
            
         }
         System.out.print("balance after all transactions= ");
         System.out.println("€"+ acc.balance+"\n");
   
   
      }
     
   
}
}