import java.util.*;

public class CollectionsTree {

	public static void main(String args[]) {

		TreeSet mytreeset = new TreeSet();
		
		mytreeset.add("C");
		mytreeset.add("A");
		mytreeset.add("B");
		mytreeset.add("E");
		mytreeset.add("F");
		mytreeset.add("D");
		System.out.println(mytreeset);
                
		mytreeset.clear();
		System.out.println(mytreeset);
                
		mytreeset.add("Pear");
		mytreeset.add("Boysenberry");
		mytreeset.add("Coconut");
		mytreeset.add("Apple");
		mytreeset.add("Guava");
		mytreeset.add("Guava"); //add duplicate Guava, this will prevented
		mytreeset.add("Pomelo");
		
		System.out.println(mytreeset);
		
		
		System.out.println("Last item: " + mytreeset.last());
		
		System.out.println("First item: " + mytreeset.first());
		System.out.println("Removing Apple from the list...");
		mytreeset.remove("Apple");
		System.out.println(mytreeset);
		System.out.println("First item now is : " + mytreeset.first());
		System.out.println("Removing Coconut from the list...");
		mytreeset.remove("Coconut");
		System.out.println(mytreeset);
		System.out.println("First item now is still: " + mytreeset.first());
		System.out.println(mytreeset);
                
		System.out.println();
		System.out.println("Working on Iterator for array:");
		Iterator mytreeset2 = mytreeset.iterator();
		while(mytreeset2.hasNext()){
			Object element = mytreeset2.next();
			System.out.print(element + " ");
			
		}
                
	}
}