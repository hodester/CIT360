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
public class MarkTree {
    
    public static void main(String[] args){
        TreeSet bookTreeSet = new TreeSet();
        TreeSet backupTreeSet = new TreeSet();
        TreeSet anotherTreeSet = new TreeSet();
        bookTreeSet.add("Rogue One");
        bookTreeSet.add("A New Hope");
        bookTreeSet.add("Heir to the Jedi");
        bookTreeSet.add("The Empire Strikes Back");
        bookTreeSet.add("Return of the Jedi");
        bookTreeSet.add("Rogue One"); // Duplicate title, This item will not be displayed.
        bookTreeSet.add("The Paradise Snare");
        bookTreeSet.add("The Hutt Gambit");
        bookTreeSet.add("Rebel Dawn");
        bookTreeSet.add("Shadows of the Empire");
        bookTreeSet.add("The Courtship of Princess Leia");
        bookTreeSet.add("I, Jedi");
        bookTreeSet.add("Rebel Dawn"); // Duplicate title, This item will not be displayed.
        
        // copy bookTreeSet to backupTreeSet
        System.out.println();
        System.out.println("Adding Elements in the bookTreeSet Set to the backupTreeSet");
        backupTreeSet.addAll(bookTreeSet);
        
        // Check to see if the Sets are empty
        System.out.println();
        System.out.println("Elements in the bookTreeSet Set ");
        if(bookTreeSet.isEmpty()){
            System.out.println("The bookTreeSet is empty");
        } else {
            System.out.println(bookTreeSet);
        }
        System.out.println();
        System.out.println("Elements in the backupTreeSet Set ");
        if(backupTreeSet.isEmpty()){
            System.out.println("The backupTreeSet is empty");
        } else {
            System.out.println(backupTreeSet);
        }
        System.out.println();
        System.out.println("Elements in the anotherTreeSet Set ");
        if(anotherTreeSet.isEmpty()){
            System.out.println("The anotherTreeSet is empty");
        } else {
            System.out.println(anotherTreeSet);
        }
        
        
        System.out.println();
        System.out.println();
        System.out.println("The first and last item of the tree set is;");
        
        System.out.println("The First Element is: " + bookTreeSet.first());
        System.out.println("The First Element is: " + bookTreeSet.last());
        
        System.out.println();
        System.out.println();
        System.out.println("The tree set arranged in ascending order:");
        System.out.print("        { ");
        
        Iterator iteratedshoeTreeSet;
        iteratedshoeTreeSet = bookTreeSet.iterator();
        while (iteratedshoeTreeSet.hasNext()){
            System.out.print(iteratedshoeTreeSet.next() + "  ");
        }
        System.out.print(" } ");
        System.out.println();
        System.out.println();
        System.out.println("Or Decending order:");
        System.out.print("        { ");
        
        iteratedshoeTreeSet = bookTreeSet.descendingIterator();
        while (iteratedshoeTreeSet.hasNext()){
            System.out.print(iteratedshoeTreeSet.next() + "  ");
        }
        System.out.print(" } ");
        System.out.println();
        System.out.println();
        
        
        System.out.println("I will remove Rogue One from the list because I am not a Rogue One fan.");
        bookTreeSet.remove("Rogue One");
        System.out.println();
        System.out.println();
        // Check to see if the Sets are empty
        System.out.println();
        System.out.println("Elements in the bookTreeSet Set ");
        if(bookTreeSet.isEmpty()){
            System.out.println("The bookTreeSet is empty");
        } else {
            System.out.println(bookTreeSet);
        }
        System.out.println();
        System.out.println("Elements in the backupTreeSet Set ");
        if(backupTreeSet.isEmpty()){
            System.out.println("The backupTreeSet is empty");
        } else {
            System.out.println(backupTreeSet);
        }
        System.out.println();
        System.out.println("Elements in the anotherTreeSet Set ");
        if(anotherTreeSet.isEmpty()){
            System.out.println("The anotherTreeSet is Still empty");
        } else {
            System.out.println(anotherTreeSet);
        }
        
        
        System.out.println();
        System.out.println("Adding Elements in the bookTreeSet Set to the anotherTreeSet");
        anotherTreeSet.addAll(bookTreeSet);
        
        System.out.println();
        System.out.println("Clearing the bookTreeSet TreeSet");
        bookTreeSet.clear();
        
        // Check to see if the Sets are empty
        System.out.println();
        System.out.println("Elements in the bookTreeSet Set ");
        if(bookTreeSet.isEmpty()){
            System.out.println("The bookTreeSet is empty");
        } else {
            System.out.println(bookTreeSet);
        }
        System.out.println();
        System.out.println("Elements in the backupTreeSet Set ");
        if(backupTreeSet.isEmpty()){
            System.out.println("The backupTreeSet is empty");
        } else {
            System.out.println(backupTreeSet);
        }
        System.out.println();
        System.out.println("Elements in the anotherTreeSet Set ");
        if(anotherTreeSet.isEmpty()){
            System.out.println("The anotherTreeSet is STILL empty");
        } else {
            System.out.println(anotherTreeSet);
        }
        
        
        System.out.println();
 
    }
    
}