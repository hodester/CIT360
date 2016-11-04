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
public class MarkList {
    
    public static void main(String[] args) {
        List bookList = new ArrayList();
        List backupList = new ArrayList();
           
        bookList.add("A New Hope");
        bookList.add("Empire Striks Back");
        bookList.add("Retun of the Jedi");
        bookList.add("Crystal Star");
        bookList.add("Empire Strikes Back");
        bookList.add("Rogue One");
        bookList.add("Courtship of Princess Leia");
        bookList.add("Rogue Squardron");
       
        System.out.println("Book List");
        System.out.println("\t" + bookList);
        
        for(int i=0; i < bookList.size(); i++){
            Object obj = bookList.get(i);
            backupList.add(obj);
        }
        
        System.out.println("Backup List");
        System.out.println("\t" + backupList);
        
        for(int i=0; i < backupList.size(); i++){
            Object obj = backupList.get(i);
            System.out.println(obj);
    
        }
        
        System.out.println();
        System.out.println("The 2nd Element is: " + bookList.get(1));
        System.out.println("I don't like " + bookList.get(1) + " let's get rid of it.");
        bookList.remove(1);
        
        System.out.println("\t" + bookList);
        
        System.out.println();
        System.out.println("I don't like Empire Strikes Back, lets remove it from the list");
        
        for(int i=0; i < bookList.size(); i++){
            Object obj = bookList.get(i);
            if (obj == "Empire Strikes Back"){
                bookList.remove("Empire Strikes Back");
            }
        
        }
        System.out.println("\t" + bookList);
        
        List newLinkedList = new LinkedList();
        
        for (int i=0; i < bookList.size(); i++){
            Object obj = bookList.get(i);
            newLinkedList.add(obj);
        }
        
        System.out.println();
        System.out.println();
        System.out.println("newLinkedList");
        System.out.println("\t" + newLinkedList);
        
        Iterator newList = newLinkedList.iterator();
        
        System.out.println();
        System.out.println();
        System.out.println("newList");
        System.out.println("\t" + newList);
        
        System.out.println();
        System.out.println();
        System.out.println("newList");
        
        System.out.print("        {");
        while(newList.hasNext()){
           Object printit = newList.next();
           System.out.print(printit + " ");
        }
        System.out.print("]");
        System.out.println();
    }
    
}
