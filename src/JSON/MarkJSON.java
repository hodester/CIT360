/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Hodes
 */
public class MarkJSON {
    public static void main(String[] args) throws Exception {
        URL Url = new URL("http://api.wunderground.com/api/22b4347c464f868e/conditions/q/Nevada/Reno-Stead.json");
        
        try {
        HttpURLConnection urlCon = (HttpURLConnection) Url.openConnection();
        
        InputStream stream = urlCon.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder result = new StringBuilder();
        String line;
        
        while((line = reader.readLine()) !=null) {
            result.append(line);
        }
        
        // This line reads parts of teh JSON data and displays it on the screen
        JSONObject json = new JSONObject(result.toString());
            JSONObject nevadaInfo = (JSONObject) json.get("current_observation");
            
            String wunderGround = "Info downloaded from: " + nevadaInfo.getJSONObject("image").getString("title") +
                    "\nLink\t\t: " + nevadaInfo.getJSONObject("image").getString("link") +
                    "\nCity\t\t: " +  nevadaInfo.getJSONObject("display_location").getString("city") +
                    "\nState\t\t: " + nevadaInfo.getJSONObject("display_location").getString("state_name") +
                    "\nTime\t\t: " + nevadaInfo.get("observation_time_rfc822") +
                    "\nTemperature\t\t: " + nevadaInfo.get("temperature_string") +
                    "\nWindchill\t\t: " + nevadaInfo.get("windchill_string") +
                    "\nRelative Humidity\t: " + nevadaInfo.get("relative_humidity") +
                    "\nWind\t\t\t: " + nevadaInfo.get("wind_string") +
                    "\nWind Direction\t\t: " + nevadaInfo.get("wind_dir") +
                    "\nBarometer Pressure\t\t: " + nevadaInfo.get("pressure_in");
        System.out.println("\nReno-Stead Weather: ");
        System.out.println("_________________________________________________");
        System.out.println(wunderGround);
    }
    
    catch(IOException e){
        System.out.println("***ERROR****ERROR****ERROR****ERROR****ERROR*** " +
                "\nURL: " + Url.toString() + "\nERROR: " + e.toString());
    }        
    }
    
}
