
import java.io.*; 
import java.net.*; 

//Kash Pritt
//Final Assignment
//SE320
//This is the server that sets up a ServerSocket to accept inputs from client, calculates a result, and sends result to client
//https://www.youtube.com/watch?v=-YXeBksk5As video to help set up client server
public class Server
{
	private static Socket socket;
	
	
  public static void main(String args[]) throws Exception 
		   { 
		  
		       // create server socket
	        ServerSocket server_socket = new ServerSocket(12345); 
	        		  
		       // connect to client 
			socket = server_socket.accept();
	        System.out.println("Connected to Client"); 
		  //create input/output writteres to recieve and write to client
	        DataInputStream input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		    DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		      
		    double height = input.readDouble();
	    	System.out.println("Height: "+height);
		        	
		   	double weight = input.readDouble();
	      	System.out.println("Weight: "+weight);
		     	    
	      	//calculate BMI and send to Client
	      	output.writeDouble( calculateBMI(height,weight));
		    
		   	//close everything after calculating
		    server_socket.close(); 
		    socket.close(); 
		    input.close();
		    output.close();

		        }
	  //Calculates basic BMI
	  public static double calculateBMI(double height, double weight)
	  {
		  return (weight/(height*height));
	  }

 }

