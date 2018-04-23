package core;

import java.util.concurrent.SynchronousQueue;

/**
* <h1>RandomProducer</h1>
* Listens for a put to place an int in the queues head then print 
* out the int along with the thread that took it.
* <p>
* This code was written to demo my Java capabilities
* for John at Perrone Robotics
*
* @author  David Diaz (David_Diaz@cox.net)
* @version 1.0
* @since   1.8 
*/
public class Listener implements Runnable {
	
	/**
	 * Queue that holds random integers
	 */
	private SynchronousQueue<Integer> queue;
	
	/**
	 * Constructor
	 * @param queue Queue that will hold random integers
	 */
	public Listener(SynchronousQueue<Integer> queue){
		this.queue = queue;
	}

	/**
	 * Run a Listener waiting for an input to the queue
	 */
	public void run() {
		while(true){
			try {
				Console.writeString("Thread: " + Thread.currentThread().getName()+ "; rand int:" + queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
