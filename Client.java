
import java.io.*;
import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;

// this is the client that takes in 2 inputs and sends it to a server, the server then sends back a calculated result that is printed here
public class Client 
{

	private static Socket socket;
	
	
	public static void main(String args[]) throws IOException
	{
	
		double weight = 0;
		double height = 0;

		
		//Scan for values for height and weight
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Please Enter your Height in meters");
			height = scan.nextDouble();
			assert 0 <=height && height <= 12: "Height has to be in meters within 0 and 10";
			System.out.println("Please Enter Weight in Kilograms");
			assert 0 <=height && height <= 500: "Weight has to be in Kilograms within 0 and 500";
			weight = scan.nextDouble();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Inputs were not numbers");
		
		}

		
		//Set up socet for server to connect too
		socket = new Socket("localhost",12345);
		System.out.println("Connected to server");
		
		//https://www.geeksforgeeks.org/establishing-the-two-way-communication-between-server-and-client-in-java/#
		 DataInputStream input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	     DataOutputStream output = new DataOutputStream(socket.getOutputStream());
	      
		//write to server
		output.writeDouble(height);
		output.writeDouble(weight);
		//get BMI from server
		System.out.println("Calculation from Server BMI " + input.readDouble());

		//end client
		 input.close();
		 output.close();
		 socket.close();

		 
	}
	
	
	
	
}
