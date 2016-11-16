/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCHibernateDB;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mhodes
 */
public class Controller {

    Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
    }

    static void creatUser(String aUserName, String aCreatedBy) {

//        System.out.print(aUserName);
//        System.out.print(aCreatedBy);
        DataBaseUser person = new DataBaseUser();
        person.setUsername(aUserName);
        person.setCreatedBy(aCreatedBy);
        person.setCreatedDate(new Date());

        Model.insertUser(person);
    }

    public static void updateUser() {

    }

    static List<DataBaseUser> listUser() {

        List<DataBaseUser> userList = Model.showAllUsers();
        Iterator<DataBaseUser> iteratedUsers = userList.iterator();
//        return (List<User>) iteratedUsers;
        return null;
    }

    public static void deleteUser() {

    }

    public static void getMainMenu() {
        DataBaseMenu menu = new DataBaseMenu();
    }

}
