import threading 
from threading import Lock, Thread
mainBalance = 1000
lock = Lock()
def deposit(num): 
   global mainBalance
   #global lock
   lock.acquire()
   mainBalance = mainBalance+num
   print("Balance When Deposited: {}".format(mainBalance)) 
   lock.release() 
  
def withdraw(num): 
    global mainBalance
    #global lock
    lock.acquire()
    if(mainBalance-num<1000):
        print("Error : Minimum balance constraint")
        return
    else:
        mainBalance=mainBalance-num
    lock.release()   
    print("Balance When Withdrawn: {}".format(mainBalance)) 
  
if __name__ == "__main__": 
    depositAmt =40
    withdrawAmt =20
    t1 = threading.Thread(target=deposit, args=(depositAmt,)) 
    t2 = threading.Thread(target=withdraw, args=(withdrawAmt,)) 
    t1.start() 
    t2.start() 
    t1.join()
    t2.join() 
    print("Done!")