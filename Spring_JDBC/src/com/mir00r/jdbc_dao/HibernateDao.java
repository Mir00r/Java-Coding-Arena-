/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.jdbc_dao;

import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
@Repository
public class HibernateDao {
    @Autowired
    SessionFactory sf;

    public SessionFactory getSf() {
        return sf;
    }

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }
    
    public int getEmployee() {
        String hql = "select count(*) from Employee";
        Query query = (Query) getSf().openSession().createQuery(hql);
       
      // return ((Long) query.uniqueResult()).intValue();
      return query.executeUpdate();
    }

}
