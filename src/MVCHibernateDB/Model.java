/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCHibernateDB;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author mhodes
 */
public class Model {

    /*
     * DataBaseUser Database functions
     */

    static void insertUser(DataBaseUser user) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

    static void updateUser(DataBaseUser updateDB) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select u from DataBaseUser as u where u.id = :uId");
        session.merge(userDB.setParameter("uId", updateDB.getUserId()));
        transaction.commit();
    }

    static void deletUser(DataBaseUser user) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
    }

    static DataBaseUser showUserByID(Integer user) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select u from DataBaseUser as u where u.id = :uId");
        userDB.setParameter("uId", user);
        DataBaseUser theUser = (DataBaseUser) userDB.uniqueResult();
        transaction.commit();
        return theUser;
    }

    static List<DataBaseUser> showAllUsers() {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select u from DataBaseUser as u");
        @SuppressWarnings("unchecked")
        List<DataBaseUser> userList = userDB.list();
        transaction.commit();
        return userList;
    }

}
