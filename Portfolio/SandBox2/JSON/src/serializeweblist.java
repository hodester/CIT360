import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



class Name {
	public Name(String firstname, String lastname) {
		this.first = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
		this.last = lastname.substring(0, 1).toUpperCase() + firstname.substring(1);
	}
	String first;
	String last;
	
    public String toString(){
    	return first + " " + last;
    }
}



public class serializeweblist {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Name> rolelist = new ArrayList<Name>();
		
	    try {
	    	System.out.println("Grabbing JSON from the web for people to join the class...");
	        URL url = new URL("https://randomuser.me/api/?results=10&nat=us&exc=login,picture,registered,id&noinfo");
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        String readStream = readStream(con.getInputStream());
	        System.out.println("Raw JSON from the web:");
	        System.out.println(readStream);
	        System.out.println("\nParser Json in to Json Object and processing the results:");
	        

	
	        JsonElement element = new JsonParser().parse(readStream);
	        
	        JsonObject root = element.getAsJsonObject();
	        
	        JsonArray array = root.getAsJsonArray("results");
	        	        
	        
	        for (int i = 0; i < array.size(); i++) {
	            JsonObject person = array.get(i).getAsJsonObject();
	            JsonObject personName = person.get("name").getAsJsonObject();
	            String firstname = personName.get("first").toString().replace("\"", "");;
	            String lastname = personName.get("last").toString().replace("\"", "");;
	            System.out.printf("Adding %s %s to the array\n", firstname, lastname);
	            rolelist.add(new Name(firstname, lastname));
	            
	        }
	        
	        System.out.println("Students in Object Class Array are:\n" + rolelist);
	        
	        String json = new Gson().toJson(rolelist);
	        System.out.println("\nObject Class Array has been serialized into a JSON string:");
	        System.out.println(json);
	        
	        
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	}


	
	private static String readStream(InputStream in) {
		    StringBuilder sb = new StringBuilder();
		    try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
		      
		      String nextLine = "";
		      while ((nextLine = reader.readLine()) != null) {
		        sb.append(nextLine);
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    return sb.toString();
	}
}
