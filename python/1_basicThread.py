import threading 
import os 
  
def foo(): 
    print("Hello Printed by thread: {}".format(threading.current_thread().name)) 
    print("ID of process running foo: {}".format(os.getpid())) 
  
def goo(): 
    print("\nBye world printed by thread: {}".format(threading.current_thread().name)) 
    print("ID of process running goo: {}".format(os.getpid())) 
  
if __name__ == "__main__": 
    print("Main thread name: {}".format(threading.current_thread().name)) 
    t1 = threading.Thread(target=foo, name='t1') 
    t2 = threading.Thread(target=goo, name='t2')   
    t1.start() 
    t2.start() 
    t1.join() 
    t2.join() 