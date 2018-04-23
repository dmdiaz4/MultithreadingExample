package core;


/**
* <h1>Start</h1>
* Contains the main function to start execution. Collects input
* then passes it to ThreadProblem
* <p>
* This code was written to demo my Java capabilities
* for John at Perrone Robotics
*
* @author  David Diaz (David_Diaz@cox.net)
* @version 1.0
* @since   1.8 
*/
public class Start {

	/**
	 * Method where execution starts see spec doc to verify correct input is being given 
	 * @param args Should be 2 integers, First is number of threads, Second is interval for queue
	 * @see [insert spec doc]
	 */
	public static void main(String[] args) {
		
		int threads=0;
		int interval=0;
		
		boolean inputsCollected = false;
		
		/*
		 * In the email you called the input console parameters so I didn't know if you wanted 
		 * the inputs passed as arguments or if you intended to input the params manually 
		 * through the console
		 */
		
		//If no args, get input manually from user
		if (args.length == 0){
			Console.writeString("How many listener threads?");
			threads = Console.readInt();
			Console.writeString("Interval(in miliseconds) for placing random ints in the queue");
			interval = Console.readInt();
			inputsCollected = true;
			
		//Checks the args are correct
		}else if((args.length == 2)&& 
				Console.isIntParseable(args[0])&& 
				Console.isIntParseable(args[1])){
			
			threads = Integer.parseInt(args[0]);
			interval = Integer.parseInt(args[1]); 
			inputsCollected = true;
			
		//Had trouble getting input from args check if they are correct
		}else{
			Console.writeString("Had trouble getting input from arguments, double check your args");
			inputsCollected = false;
		}		
		
		
		if (inputsCollected){
			ThreadProblem problem = new ThreadProblem(threads,interval);
			problem.execute();
		}
		
	}

}
