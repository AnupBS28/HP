import threading
lock = threading.Lock()

queue = []

def enqueue(x) :
    global queue
    lock.acquire()	
    print("ThreadName :"+threading.currentThread().getName() + " is enqueuing " + str(x))
    queue.append(x)
    print(queue)
    lock.release()

def dequeue() :
    lock.acquire()
    global queue	
    if(len(queue)>0) :
        #remove from the front of the queue queue[0]
        print("ThreadName :"+threading.currentThread().getName() + " is dequeuing " + str(queue[0]))
        queue.remove(queue[0])
        print(queue)
    lock.release()


threadList=[]
for i in range(0,25):
    if(i%2==0 or i%5==0):
        threadList.append(threading.Thread(target=enqueue, args=(i,)))
    else:
        threadList.append(threading.Thread(target=dequeue, args=()))


for i in threadList :
	i.start()
for i in threadList :
	i.join()
