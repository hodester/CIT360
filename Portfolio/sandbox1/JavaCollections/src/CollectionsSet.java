import java.util.*;

public class CollectionsSet {

	public static void main(String args[]) {
		HashSet myset = new HashSet();
		myset.add("B");
		myset.add("D");
		myset.add("A");
		myset.add("E");
		myset.add("E"); //add duplicate E, this will prevented
		myset.add("R");
		myset.add("T");
		System.out.println(myset);
		
		
		HashSet myset2 = new HashSet();
		myset2.add("Boysenberry");
		myset2.add("Coconut");
		myset2.add("Apple");
		myset2.add("Guava");
		myset2.add("Guava"); //add duplicate Guava, this will prevented
		myset2.add("Pomelo");
		myset2.add("Pear");
		System.out.println(myset2);
		System.out.println("Now removing Apple from the list");
		myset2.remove("Apple");
		System.out.println(myset2);

		System.out.println();
		System.out.println("Working on Iterator for array:");
		Iterator myset2a = myset2.iterator();
		while(myset2a.hasNext()){
			Object element = myset2a.next();
			System.out.print(element + " ");
			
		}
                
	}
}