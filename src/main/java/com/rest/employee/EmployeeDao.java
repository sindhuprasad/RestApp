package com.rest.employee;

import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by Sindhu on 8/13/15.
 */

@Repository
public class EmployeeDao {
    private JdbcTemplate jt;

    @Autowired
    public DataSource dataSource;



    public Employee getEmployee(int employeeID){
        final String sql = "select * from Employee where EmployeeID = ?";

        Employee result = null;

        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            result = jdbcTemplate.queryForObject(sql, new Object[] { employeeID }, new RowMapper<Employee>() {
                @Override
                public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                    Employee emp = new Employee();
                    emp.setEmployeeID(resultSet.getInt("EmployeeID"));
                    emp.setEmail(resultSet.getString("Email"));
                    emp.setFirstName(resultSet.getString("FirstName"));
                    emp.setLastName(resultSet.getString("LastName"));
                    return emp;
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public Employee createEmployee(final Employee e){

        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "INSERT INTO Employee (FirstName, LastName, Email)" + " VALUES (?, ?, ?)";
       // jt.update(sql, e.getFirstName(), e.getLastName(), e.getEmail());

        try{
            jt = new JdbcTemplate(dataSource);
            jt.update(
                    new PreparedStatementCreator() {
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            int index = 1;
                            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                            ps.setString(index++, e.getFirstName());
                            ps.setString(index++, e.getLastName());
                            ps.setString(index++, e.getEmail());
                            return ps;
                        }
                    },
                    keyHolder);
            e.setEmployeeID(keyHolder.getKey().intValue());
        }catch (Exception e1){
            System.out.println(e1);
        }



        return e;
    }
}
