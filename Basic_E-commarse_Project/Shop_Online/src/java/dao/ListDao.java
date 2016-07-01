/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.Product;
import entity.SubCategory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
public class ListDao {

    public List catList() {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        String sql = "SELECT al.catName FROM Category al";
        List < Category > clist = session.createQuery(sql).list();
        clist.toString();
        
        session.close();
        return clist;
    }
    
     public List subcatList( String name ) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        String sql = "SELECT al.subCatName FROM SubCategory al "
                + "where al.category.catId "
                + "IN (SELECT a.catId FROM Category a "
                + "where lower (a.catName) = '"+ name.toLowerCase() +"' )";
        
        List < SubCategory > clist = session.createQuery(sql).list();
        clist.toString();
        
        session.close();
        return clist;
    }
    
    public List< Category > catListByName( String name ) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        String sql = "SELECT al FROM Category al "
                + "where lower(catName) = '"+ name.toLowerCase() +"' ";
        
        List < Category > clist = session.createQuery(sql).list();
        clist.toString();
        
        session.close();
        return clist;
    }
    
    public List< SubCategory > subcatListByName( String name ) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        String sql = "SELECT al FROM SubCategory al "
                + "where lower(subCatName) = '"+ name.toLowerCase() +"' ";
        
        List < SubCategory > clist = session.createQuery(sql).list();
        clist.toString();
        
        session.close();
        return clist;
    }
    
    
    public List allProductList() {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        String sql = "SELECT al FROM Product al";
        List < Product > plist = session.createQuery(sql).list();
        plist.toString();
        
        session.close();
        return plist;
    }   
}
