package Threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class MyRunnable implements Runnable {
	BlockingQueue<Integer> bq;
	
    @Override
    public void run() {
    	bq = new ArrayBlockingQueue<Integer>(20);
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Value: " + i);
            try {
				bq.offer(i, 1, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }finally {
            	System.out.println(bq);
			}
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        
        Thread t1 = new Thread(runnable, "Mani 1");
        Thread t2 = new Thread(runnable, "Mani 2");

        // Start the threads
        t1.start();       
        t2.start();

    }
}
