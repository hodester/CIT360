package DailyInfo;

/**
*
* @author Peter Wong
* @description Generates a morning information update
* @notes It will display the current Date, Weather, Horoscope and lucky numbers for the day.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.SimpleDateFormat;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class InfoController {
	private static String wtemp;
	private static String wtext;
	private static String horoscope;
	private static List<Number> numberList = new ArrayList<Number>();
	static Map<Character, Runnable> commands = new HashMap<>();
	
	static void populateHashMap(){
		commands.put('w', () -> updateWeather());
		commands.put('h', () -> updateHoroscope());
		commands.put('n', () -> updateNumberList());
		
	}

	static void updateWeather(){
		JsonElement element = null;
		JsonObject root = null;
    	System.out.println("Updating Weather Information...");
        try {
			element = readUrl("https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20%3D%202487889&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        root = element.getAsJsonObject().getAsJsonObject("query").getAsJsonObject("results").getAsJsonObject("channel").getAsJsonObject("item").getAsJsonObject("condition");
        wtemp = root.get("temp").toString().replace("\"", "");
        wtext = root.get("text").toString().replace("\"", "");
	}
	static void updateHoroscope(){
		JsonElement element = null;
		JsonObject root = null;
    	System.out.println("Updating Horoscope Information...");
        try {
			element = readUrl("http://widgets.fabulously40.com/horoscope.json?sign=pisces");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        root = element.getAsJsonObject().getAsJsonObject("horoscope");
        horoscope = root.get("horoscope").toString().replace("\"", "");
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

	public static String getWTemp() {
		return wtemp;
	}

	public static String getWText() {
		return wtext;
	}
	public static String getHoroscope() {
		return horoscope;
	}	


	public static String getDate(){
		Date now = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		return dateFormatter.format(now);
	}
	
	private static JsonElement readUrl(String urlString) throws Exception {
		URL url = null;
		HttpURLConnection con = null;
		String readStream = null;
		JsonElement element = null;
	    try {
	        url = new URL(urlString);
	        con = (HttpURLConnection) url.openConnection();
	        readStream = readStream(con.getInputStream());
	        element = new JsonParser().parse(readStream);


	    } catch (IOException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	static void addNumberList(int number){
		numberList.add(number);
	}
	static String getNumberList(){
		return numberList.toString();
	}	
	static void updateNumberList(){
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new getThread("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}

	}

		
}
