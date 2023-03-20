package service;

import model.Department;
import model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static connection.ConnectDB.getConnection;

public class DepartmentService {
    public static final String SELECT_DEPARTMENT_BY_ID = "select id_der, name from departmentStaff where id_der = ?";

    public Department findById(int id) {
        Department department = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SELECT_DEPARTMENT_BY_ID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                department =new Department(id, name);
            }
            connection.commit();
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return department;
    }
}
