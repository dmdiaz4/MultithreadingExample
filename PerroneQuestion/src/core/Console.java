package core;

import java.util.Scanner;

/**
* <h1>Console</h1>
* Send and receive data/messages through the console. 
* <p>
* This code was written to demo my Java capabilities
* for John at Perrone Robotics
*
* @author  David Diaz (David_Diaz@cox.net)
* @version 1.0
* @since   1.8 
*/
public class Console {

	/**
	 * Scanner used to read inputs
	 */
	private static Scanner in;
	
	
	/**
	 * Write to the console
	 * @param msg Message written to the console window
	 */
	public static void writeString(String msg){
		System.out.println(msg);
	}
	
	/**
	 * Reads an integer from the console
	 * @return int The integer that was entered into the console
	 */
	
	public static int readInt(){
		String data = "";
		int readInt = 0;
		boolean validInput = false;
		while(!validInput){
			in = new Scanner(System.in);
			data = in.nextLine();
			if (isIntParseable(data)) {
				readInt = Integer.parseInt(data);
				validInput= true;
			} else {
				writeString("Input Mismatch: Enter an integer");
				validInput= false;
			}
		}
		return readInt;
	}
	
	/**
	 * Checks if the string can be parsed into an integer
	 * @param s String that is checked
	 * @return boolean If the string can be parsed
	 */
	public static boolean isIntParseable(String s){
		boolean isIntParseable = false;
		try{
			Integer.parseInt(s);
			isIntParseable = true;
		}catch(Exception e){
			// can't parse
			isIntParseable = false;
		}
		return isIntParseable;
	}
	
}
