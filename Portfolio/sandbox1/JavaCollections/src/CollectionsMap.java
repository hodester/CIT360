/* Peter Wong*/
import java.util.*;

public class CollectionsMap {

	public static void main(String[] args) {
      
		Map m1 = new HashMap(); 
		m1.put("Zoe", "2");
		m1.put("Joy", "1");
		m1.put("William", "1");
		m1.put("Peter", "32");
		System.out.println();
		System.out.println(" Map Elements");
		System.out.print("\t" + m1);
		System.out.println();
		System.out.print("William is " + m1.get("William") + " this year.");
		System.out.println();
		m1.put("William", "2");
		System.out.println();
		System.out.print("William is " + m1.get("William") + " this year.");
		System.out.println();
		m1.put("William", "3");
		System.out.println();
		System.out.print("William is " + m1.get("William") + " this year.");
		System.out.println();
		m1.put("William", "4");
		System.out.println();
		System.out.print("William is " + m1.get("William") + " this year.");
		System.out.println();
      
	}
}