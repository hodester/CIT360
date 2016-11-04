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
public class MarkSet {
    
    public static void main(String[] args){
        
        HashSet shoeSet = new HashSet();
        HashSet backupSet = new HashSet();
        HashSet anotherSet = new HashSet();
               
        shoeSet.add("Mizuno");
        shoeSet.add("Asics");
        shoeSet.add("Altra");
        shoeSet.add("New Balance");
        shoeSet.add("Nike");
        shoeSet.add("Brooks");
        shoeSet.add("Mizuno");
        shoeSet.add("Adidas");
        shoeSet.add("Saucony");
        shoeSet.add("Hoka");
        shoeSet.add("Altra");

        backupSet.addAll(shoeSet);
        
        System.out.println();
        System.out.println("Elements in the shoeSet Set ");
        if(shoeSet.isEmpty()){
            System.out.println("The shoeSet is empty");
        } else {
            System.out.println(shoeSet);
        }
        
        System.out.println();
        System.out.println("Elements in the backupSet Set ");
        if(backupSet.isEmpty()){
            System.out.println("The backupSet is empty");
        } else {
            System.out.println(backupSet);
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
        
        
        Iterator aLinkedSet = shoeSet.iterator();
        
        while(aLinkedSet.hasNext()){
            System.out.print(aLinkedSet.next() + " ");
        }
        
        System.out.println();
        System.out.println();
                
        
        System.out.println();
        System.out.println();
        
    }
    
}
