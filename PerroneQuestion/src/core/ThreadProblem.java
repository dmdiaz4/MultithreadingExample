package core;

import java.util.concurrent.*;

/**
* <h1>ThreadProblem</h1>
* Solves thread problem :Create a pool of “listener” threads that wait on a Queue. 
* Creates another thread that puts random values as “Integer” Java Objects onto the 
* queue at an interval
* <p>
* This code was written to demo my Java capabilities
* for John at Perrone Robotics
*
* @author  David Diaz (David_Diaz@cox.net)
* @version 1.0
* @since   1.8 
*/
public class ThreadProblem {
	
	private int threads;
	private int interval;
	
	/**
	 * Constructor
	 * @param threads Number of threads in the pool
	 * @param interval Interval of when to input random values into a queue
	 */
	public ThreadProblem(int threads,int interval){
		this.threads = threads;
		this.interval = interval;
		
	}
	/**
	 * Create a pool of “listener” threads that wait on a Queue. 
	 * Creates another thread that puts random values as “Integer” Java Objects onto the 
	 * queue at an interval
	 */
	public void execute (){
		SynchronousQueue<Integer> randQueue = new SynchronousQueue<Integer>();
		
		//ScheduledExecutorService sThread = Executors.newSingleThreadScheduledExecutor();  // thread for adding to queue at an interval
		//sThread.scheduleAtFixedRate(new RandomProducer(randQueue), 0, interval, TimeUnit.SECONDS);
		Thread sThread = new Thread(new RandomProducer(randQueue, interval),"Random Integer Producer thread");
		sThread.setPriority(Thread.MAX_PRIORITY);
		
		sThread.start();
		
		ExecutorService pool= Executors.newFixedThreadPool(threads);// n number of threads to listen for the queue change
		for(int i = 0; i<threads; i++){
			pool.execute(new Listener(randQueue));
		}
		
		pool.shutdown();

		
	}
	


}
