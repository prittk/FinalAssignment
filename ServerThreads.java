
import java.io.*; 
import java.net.*; 
//Similar to the regular server, but instead makes threads in a loop and continuesly connects to the,
////https://www.geeksforgeeks.org/multithreaded-servers-in-java/# for making the runnable

public class ServerThreads {
	
	

private static Socket socket;
	
	
  public static void main(String args[]) throws Exception 
		   { 
	  
		  	socket= null;
		    // Create server Socket 
	        ServerSocket server_socket = new ServerSocket(12345);
	        server_socket.setReuseAddress(true);
	               		  
		    // connect to client and create threads for each connection.
	        while (true)
	        {
	        	
			socket = server_socket.accept();
	        System.out.println("Connected to a Client " + socket.getInetAddress().getHostAddress());      
		    
	        ClientHandler clients = new ClientHandler(socket);
	        
	        new Thread(clients).start();

		        }
		   }
	  
	
 }
//creates the client threads
  class ClientHandler implements Runnable
  { 
     private final Socket client_socket;
     private DataInputStream input=null;
     private  DataOutputStream output=null;

      // Constructor 
      public ClientHandler(Socket socket) 
      { 
          this.client_socket = socket; 
      } 
      //calculate bmi
      public static double calculateBMI(double height, double weight)
	  {
		  return (weight/(height*height));
	  }

//Thread class that take height and weight from client and sends back a double
      public void run() 
      { 
         
          try { 
        	  //create input/output stream
        	input = new DataInputStream(new BufferedInputStream(client_socket.getInputStream()));
  		    output = new DataOutputStream(client_socket.getOutputStream());
        	  //read clients for height and weight
        	    double height = input.readDouble();
    	    	System.out.println("Height: "+height);
    		        	
    		   	double weight = input.readDouble();
    	      	System.out.println("Weight: "+weight);
    	      	
    		   	output.writeDouble( calculateBMI(height,weight));
    		   	output.flush();

          } 
          catch (IOException e) { 
              e.printStackTrace(); 
          } 
       //close when no reading or listening
        	  try {
        	
        	  if((input !=null) && (output != null))
        	  {
        		  input.close();
        		  client_socket.close();
        	  }
        	  
        	  }
        	  catch(IOException e)
        	  {
        		  e.printStackTrace();
        	  }
          
             
          } 
      } 



