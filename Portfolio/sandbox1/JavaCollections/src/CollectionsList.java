/* Peter Wong*/
import java.util.*;

public class CollectionsList {

	public static void main(String[] args) {
		List myarraylist = new ArrayList();
		myarraylist.add("Carrots");
		myarraylist.add("Milk");
		myarraylist.add("Stakes");
		myarraylist.add("Potatoes");
		System.out.println(" ArrayList Elements");
		System.out.print("\t" + myarraylist);
		System.out.println();
		System.out.println("Second Elements is: "+  myarraylist.get(1));
		System.out.println("Removing second item..");
		myarraylist.remove(1);
		System.out.println("Second Elements now is: "+  myarraylist.get(1));
		List myLinkedList = new LinkedList();
		myLinkedList.add("Carrots");
		myLinkedList.add("Milk");
		myLinkedList.add("Stakes");
		myLinkedList.add("Potatoes");
		
		
		System.out.println();
		System.out.println(" LinkedList Elements");
		System.out.print("\t" + myLinkedList);
		System.out.println();
		System.out.println("Third Elements is: "+  myLinkedList.get(2));
		System.out.println("Removing second item..");
		myLinkedList.remove(2);
		System.out.println("Third Elements now is: "+  myLinkedList.get(2));      
		
		System.out.println();
		System.out.println("Working on Iterator for array:");
		Iterator myLinkedList2 = myLinkedList.iterator();
		while(myLinkedList2.hasNext()){
			Object element = myLinkedList2.next();
			System.out.print(element + " ");
          
		}
	}
}