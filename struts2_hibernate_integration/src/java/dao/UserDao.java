/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
class UserDao {

    public boolean find(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = " from Users u "
                + "where u.uname=:name "
                + "and u.pwd=:pass";
        
        Query query = session.createQuery(sql);
        
        query.setParameter("name", name);
        query.setParameter("pass", password);
        
        List< Users > list = query.list();
        
        if (list.size() > 0) {
            session.close();
            return true;
        }
        session.close();
        return false;
    }
}
