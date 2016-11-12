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
 * Instructions
 * Java Collections (one each of Map, List, Set, and Tree Types), Addition, Removal, using Iterators.
 * 
 */
public class MarkSet {
    
    public static void main(String[] args){
        
        HashSet bookSet = new HashSet();
        HashSet backupSet = new HashSet();
        HashSet anotherSet = new HashSet();
               
        bookSet.add("Rogue One");
        bookSet.add("A New Hope");
        bookSet.add("Heir to the Jedi");
        bookSet.add("The Empire Strikes Back");
        bookSet.add("Return of the Jedi");
        bookSet.add("Rogue One"); // Duplicate title, This item will not be displayed.
        bookSet.add("The Paradise Snare");
        bookSet.add("The Hutt Gambit");
        bookSet.add("Rebel Dawn");
        bookSet.add("Shadows of the Empire");
        bookSet.add("The Courtship of Princess Leia");
        bookSet.add("I, Jedi");
        bookSet.add("Rebel Dawn"); // Duplicate title, This item will not be displayed.

        //Copies the bookSet to backupSet
        backupSet.addAll(bookSet);
        
        //Checks for empty sets
        System.out.println();
        System.out.println("Elements in the bookSet Set ");
        if(bookSet.isEmpty()){
            System.out.println("The bookSet is empty");
        } else {
            System.out.println(bookSet);
        }
        
        System.out.println();
        System.out.println("Elements in the backupSet Set ");
        if(backupSet.isEmpty()){
            System.out.println("The backupSet is empty");
        } else {
            System.out.println("This is the backupSet" + backupSet);
        }
        
        System.out.println();
        System.out.println("Elements in the anotherSet Set ");
        if(anotherSet.isEmpty()){
            System.out.println("The anotherSet is empty");
        } else {
            System.out.println(anotherSet);
        }
        
        System.out.println();
        System.out.println();
        
        // Iterate set
        Iterator alinkedSet = bookSet.iterator();
        System.out.println("An Iterated Set:");
        while(alinkedSet.hasNext()){
            Object printit = alinkedSet.next();
            System.out.print(printit + " ");
        }
        
        System.out.println();
        System.out.println();
        
        
        System.out.println("I don't like Rebel Dawn let's get rid of it from the Set");
        System.out.println("using a standard remove() statment");
        bookSet.remove("Rebel Dawn");
        System.out.println();
        System.out.println("Rebel Dawn is now gone from the Set");
        System.out.println(bookSet);
        
        // Copy a Set to another Set
        for(int i=0; i<bookSet.size(); i++){
            anotherSet.add(i);
        }
        System.out.println();
        System.out.println("Elements now in the anotherSet Set ");
        if(anotherSet.isEmpty()){
            System.out.println("The anotherSet is empty");
        } else {
            System.out.println(anotherSet);
        }
        
        
        System.out.println("Adding the contents of bookSet to the anotherSet");
        anotherSet.addAll(bookSet);
        System.out.println("Updated elements now in the anotherSet Set ");
        System.out.println(anotherSet);
        
        System.out.println();
        System.out.println("What a mess you can make of Sets");
    
        // Remove by Iterator
        for(int i=0; i<bookSet.size(); i++){
            anotherSet.remove(i);
        }
        System.out.println("Removing Elements with Iterator");
        System.out.println("Updated elements now in the anotherSet Set ");
        System.out.println(anotherSet);
        
        System.out.println();
 
    }
    
}