package JavaCollections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author mhodes
 */
public class MarkMap {
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        HashMap bookMap = new HashMap();
        // HashMap backupSet = new HashMap();
        // HashMap anotherSet = new HashMap();
        System.out.println("Adding Rogue One, 8 an an Elements in the bookMap Map");
        bookMap.put("Rogue One", 8);
        System.out.print("\t" + bookMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Heir to the Jedi, 7 an an Elements in the bookMap Map");
        bookMap.put("Heir to the Jedi", 7);
        System.out.print("\t" + bookMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Return of the Jedi, 10 an an Elements in the bookMap Map");
        bookMap.put("Return of the Jedi", 10);
        System.out.print("\t" + bookMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding A New Hope, 6 an an Elements in the bookMap Map");
        bookMap.put("A New Hope", 6);
        System.out.print("\t" + bookMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Return of the Jedi, 1 an an Elements in the bookMap Map");
        bookMap.put("Return of the Jedi", 1);       // Duplicate, this will overwrite the first
        System.out.print("\t" + bookMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding The Paradise Snare, 2 an an Elements in the bookMap Map");
        bookMap.put("The Paradise Snare", 2);
        System.out.print("\t" + bookMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding The Hutt Gambit, 3 an an Elements in the bookMap Map");
        bookMap.put("The Hutt Gambit", 3);
        System.out.print("\t" + bookMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Return of the Jedi, 9 an an Elements in the bookMap Map");
        bookMap.put("Return of the Jedi", 9);       // Duplicate, this will overwrite any already added
        System.out.print("\t" + bookMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding The Courtship of Priness Leia, 4 an an Elements in the bookMap Map");
        bookMap.put("The Courtship of Priness Leia", 4);
        System.out.print("\t" + bookMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Shadows of the Empire, 5 an an Elements in the bookMap Map");
        bookMap.put("Shadows of the Empire", 5);
        System.out.print("\t" + bookMap);
        
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Elements in the bookMap Map");
        System.out.print("\t" + bookMap);
        
        
        
        System.out.println();
        System.out.println();
        
        // Lets loop or Iterate through the Map
        System.out.println("Iterate elements in the bookMap Map");
        System.out.print("        { ");
        for (Iterator it = bookMap.entrySet().iterator(); it.hasNext();) {
            Object printit = it.next();
            System.out.print(printit + "  ");
        }
        System.out.print(" }");
        
        System.out.println();
        System.out.println();
        
        // Lets loop or Iterate through the Map
        System.out.println("Not a Return of the Jedi Fan, let Iterate the elements to change the 9 to a 10 in bookMap Map");
        for (Iterator it = bookMap.entrySet().iterator(); it.hasNext();) {
            // Map does not support a partial search of elements BUT
            // by converting the element to a string you can search
            // for a partial word with contains()
            if(it.next().toString().contains("Return of the Jedi")){
                bookMap.put("Return of the Jedi", 10);
            }
        }
        
        System.out.print("        { ");
        for (Iterator it = bookMap.entrySet().iterator(); it.hasNext();) {
            Object printit = it.next();
            System.out.print(printit + "  ");
        }
        System.out.print(" }");
        
        System.out.println();
        System.out.println();
        
        
        
        // Lets loop or Iterate through the Map
        System.out.println("Still not a Return of the Jedi Fan, let Iterate the elements to remove it from bookMap Map");
        for (Iterator it = bookMap.entrySet().iterator(); it.hasNext();) {
            // Map does not support a partial search of elements BUT
            // by converting the element to a string you can search
            // for a partial word with contains()
            if(it.next().toString().contains("Return of the Jedi")){
                it.remove();
            }
        }
        
        
        
        System.out.print("        { ");
        for (Iterator it = bookMap.entrySet().iterator(); it.hasNext();) {
            Object printit = it.next();
            System.out.print(printit + "  ");
        }
        System.out.print(" }");
        
        System.out.println();
        System.out.println();

    }
}