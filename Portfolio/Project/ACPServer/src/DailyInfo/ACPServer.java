package DailyInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
*
* @author Peter Wong
* @description Server for information
*/

public class ACPServer {

	
	public static void main(String[] args) throws IOException {
		
		String instring = null;
		String outstring = null;
		boolean bye = false;


		System.out.println();
		InfoController.populateHashMap();
		InfoController.commands.get('w').run();
		InfoController.commands.get('h').run();
		InfoController.commands.get('n').run();
		        
        ServerSocket serverSocket = null;
        try {
        	serverSocket = new ServerSocket(9090);
        }
        catch (IOException e){
            System.err.println("Could not listen on port: 9090."); 
            System.exit(1); 
        }
        
        Socket clientSocket = null; 

        try { 
             System.out.println ("Waiting for Client");
             clientSocket = serverSocket.accept(); 
            } 
        catch (IOException e){ 
             System.err.println("Accept failed."); 
             System.exit(1); 
            }        
        ObjectOutputStream outdata = new ObjectOutputStream(clientSocket.getOutputStream()); 
        ObjectInputStream indata = new ObjectInputStream(clientSocket.getInputStream()); 
        
      //wait for client
		try {
		instring = (String) indata.readObject();
		System.out.println("Client: " + instring);
		
		}
		catch (Exception ex){
         System.err.println (ex.getMessage());
        }
		if (instring.toLowerCase().contains("hello")){
			System.out.println("Sending hello to client");
			outdata.writeObject("Good Morning Peter Wong\nToday is " + InfoController.getDate());
			outdata.flush();
			
		while(!bye){	
		//send to server	
		System.out.println("Sending instructions to client");
		outdata.writeObject("Please enter in a command( w for Weather, h for Horoscope, n for Random Number List, and q to quit):");
		outdata.flush();

		
		//wait for client
		try {
		System.out.println ("Waiting for Client");
		instring = (String) indata.readObject();
		System.out.println("Client: " + instring);
		}
		catch (Exception ex){
         System.err.println (ex.getMessage());
        }
		
        switch (instring) {
        case "w":  outstring = String.format("Temperature is %sF and looks %s\n", InfoController.getWTemp(), InfoController.getWText());
        	break;
        case "h":  outstring = String.format("You Horoscope today is:\n%s\n", InfoController.getHoroscope());
            break;
        case "n":  outstring = String.format("Lucky Numbers are: \n" + InfoController.getNumberList());
        	break;
        case "q":  outstring = "Good bye.";
        	bye = true;
        	break;         
        default: outstring = "Invalid Command, please try again";
        	break;
    }		
   		
        System.out.println("Sending response to client");
		outdata.writeObject(outstring);
		outdata.flush();


		}
		
		}

        outdata.close(); 
        indata.close(); 
        clientSocket.close(); 
        serverSocket.close(); 
        System.out.println("Good Bye. Exiting...");
        
	}
}
