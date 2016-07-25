/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.jdbc_dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class EdSupportDao extends JdbcDaoSupport{
    public String getEmployeeId ( int id ) {
        String sql = "select name from employee where id=?";
        
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, String.class);
    }
}
