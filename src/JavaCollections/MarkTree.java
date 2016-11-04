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
        
        TreeSet shoeTreeSet = new TreeSet();
        TreeSet backupSet = new TreeSet();
        TreeSet anotherSet = new TreeSet();
               
        shoeTreeSet.add("Mizuno");
        shoeTreeSet.add("Asics");
        shoeTreeSet.add("Altra");
        shoeTreeSet.add("New Balance");
        shoeTreeSet.add("Nike");
        shoeTreeSet.add("Brooks");
        shoeTreeSet.add("Mizuno");
        shoeTreeSet.add("Adidas");
        shoeTreeSet.add("Saucony");
        shoeTreeSet.add("Hoka");
        shoeTreeSet.add("Altra");

        backupSet.addAll(shoeTreeSet);
        
        System.out.println();
        System.out.println("Elements in the shoeTreeSet Set ");
        if(shoeTreeSet.isEmpty()){
            System.out.println("The shoeTreeSet is empty");
        } else {
            System.out.println(shoeTreeSet);
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
        
        
        Iterator iteratedshoeTreeSet = shoeTreeSet.iterator();
        
        
        
        System.out.println();
        System.out.println();
        
    }
    
}
