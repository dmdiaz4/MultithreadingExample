package core;

import java.util.Random; 
import java.util.concurrent.SynchronousQueue;

/**
* <h1>RandomProducer</h1>
* Produced a random number then add it to a synchronousQueue
* <p>
* This code was written to demo my Java capabilities
* for John at Perrone Robotics
*
* @author  David Diaz (David_Diaz@cox.net)
* @version 1.0
* @since   1.8 
*/
public class RandomProducer implements Runnable {
	
	/**
	 * Queue that holds random integers
	 */
	private SynchronousQueue<Integer> queue;
	
	/**
	 * Interval in miliseconds to put the integers into the queue
	 */
	private int interval=0;
	
	/**
	 * Constructor
	 * @param queue Queue that will hold random integers
	 * @param interval Interval in milliseconds
	 */
	RandomProducer(SynchronousQueue<Integer> queue, int interval){
		this.queue = queue;
		this.interval = interval;
	}

	/**
	 * Run a Random number producer that is added to the queue between intervals
	 */
	public void run() {
		Random randNum = new Random();
		while(true){
			randNum = new Random();
			try {
				int i = randNum.nextInt();
				queue.put(i);
				//Console.writeString("Put in Queue  "+i);
				Thread.currentThread().sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
