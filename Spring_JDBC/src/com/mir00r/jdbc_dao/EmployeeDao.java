/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.jdbc_dao;

import com.mir00r.jdbc_model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */

@Component
public class EmployeeDao {
    DataSource dataSource;
    JdbcTemplate jdbctemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    public DataSource getDataSource() {
        return dataSource;
    }
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
       // this.dataSource = dataSource;
       jdbctemplate = new JdbcTemplate(dataSource);
       namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    
    public int SaveEmployee ( Employee employee ) {
        String sql = " insert into employee(name, salary) "
                + "values( '"+ employee.getName() +"',"
                + " '"+ employee.getSalary() +"' ) ";
        
        return jdbctemplate.update(sql);
    }
    
    public int SaveEmployeeByPS ( Employee employee ) {
        String sql = " insert into employee(name, salary) "
                + "values( ?, ? ) ";
        
        return jdbctemplate.update(sql, 
                new Object[]{employee.getName(), employee.getSalary()});
    }
    
    public int SaveEmployeeByNPS ( Employee employee ) {
        String sql = " insert into employee(name, salary) "
                + "values( :name, :salary ) ";
        
        SqlParameterSource nameParameterSource = 
                new MapSqlParameterSource("name", employee.getName()).addValue("salary", employee.getSalary());
        
        return namedParameterJdbcTemplate.update(sql, 
                nameParameterSource);
    }
    
    
    
    
    
    
    public String getEmployeeId ( int id ) {
        String sql = "select name from employee where id=?";
        
        return jdbctemplate.queryForObject(sql, new Object[]{id}, String.class);
    }
    
    public Employee getAllEmployeeInfo ( int id ) {
        String sql = "select * from employee where id=?";
        
        return jdbctemplate.queryForObject(sql, new Object[]{id}, new EmployeeMapper());
    }
    
    public List<Employee> getAllEmployeeList ( int id ) {
       // String sql = "select * from employee where id=?";
        String sql = "select * from employee ";
        //return jdbctemplate.query(sql, new Object[]{id}, new EmployeeMapper());
        return jdbctemplate.query(sql, new EmployeeMapper());
    }
    
    private static class EmployeeMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            
            // set all column name 
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setSalary(rs.getDouble("salary"));
            
            return employee;
        }
        
    }
    
}
