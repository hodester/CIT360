package DailyInfo;

/**
*
* @author Peter Wong
* @description Generates a morning information update
* @notes It will display the current Date, Weather, Horoscope and lucky numbers for the day.
*/

public class MyInfo {

	
	public static void main(String[] args){
		goodMorningRoutine();
	}
	
	public static void goodMorningRoutine(){
		System.out.println("Good Morning Peter Wong");
		System.out.println("Today is " + InfoController.getDate());

		System.out.println();
		InfoController.populateHashMap();
		InfoController.commands.get('w').run();
		InfoController.commands.get('h').run();
		InfoController.commands.get('n').run();
		
		System.out.println();
        System.out.printf("Temperature is %sF and looks %s\n", InfoController.getWTemp(), InfoController.getWText());
        System.out.println();
        System.out.printf("You Horoscope today is:\n%s\n", InfoController.getHoroscope());		
        System.out.println("Lucky Numbers are: \n" + InfoController.getNumberList());
		
	}
}
