package DailyInfo;

/**
*
* @author Peter Wong
* @description Generates a morning information update
* @notes It will display the current Date, Weather, Horoscope and lucky numbers for the day.
*/

import java.util.Random;

public class getThread implements Runnable {

    private String command;

    public getThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
    	Random randomGenerator = new Random();
    	int randomInt;
		while (true){
    		randomInt = randomGenerator.nextInt(100);
    		if ((100 > randomInt || randomInt > 0)) break;
    	}
    	InfoController.addNumberList(randomInt);
    }

    @Override
    public String toString(){
        return this.command;
    }
}