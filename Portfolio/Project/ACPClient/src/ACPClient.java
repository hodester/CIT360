import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
*
* @author Peter Wong
* @description ACP Client that connects to the server to get information.
*/

public class ACPClient {

	public static void main(String[] args)  throws IOException {
		boolean bye = false;
		String instring = null;
		Socket echoSocket = null;
        ObjectOutputStream outdata = null;
        ObjectInputStream indata = null;
        String servername = "localhost";
        Scanner scanner = new Scanner(System.in);

        try {

            echoSocket = new Socket(servername, 9090);
            
            outdata = new ObjectOutputStream(echoSocket.getOutputStream());
            indata = new ObjectInputStream(echoSocket.getInputStream());

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + servername);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + servername + ".");
            System.exit(1);
        }
        
        //say hello to the server
        System.out.println("Sending hello to server");
		outdata.writeObject("hello");
		outdata.flush();
		
        //wait for response
		try {
		instring = (String) indata.readObject();
		System.out.println(instring);
		}
		catch (Exception ex){
         System.err.println (ex.getMessage());
        }

		while (!bye){
	        //wait for response
			try {
			instring = (String) indata.readObject();
			System.out.print(instring);
			}
			catch (Exception ex){
	         System.err.println (ex.getMessage());
	        }
			
			
			String command = scanner.next();
			//send command to server
			System.out.println("Sending command to server");
			outdata.writeObject(command);
			outdata.flush();
			
	        //wait for response
	        try {
			instring = (String) indata.readObject();
			System.out.println("Server: " + instring);
			}
			catch (Exception ex){
	         System.err.println (ex.getMessage());
	        }
	        if (instring.toLowerCase().contains("bye")) bye = true;
		}
		scanner.close();
        outdata.close(); 
        indata.close(); 
        echoSocket.close();

	}

}
