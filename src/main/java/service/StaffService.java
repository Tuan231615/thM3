package service;

import model.Department;
import model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static connection.ConnectDB.getConnection;

public class StaffService implements IStaffService{
public void staffService(){}
    DepartmentService departmentService = new DepartmentService();
    private static final String SELECT_ALL_STAFFS = "select st.id, st.name, st.email, st.address, st.phone, st.salary," +
            " st.id_depart, de.id_der, de.name from staffmanager st join departmentStaff de on st.id_depart=de.id_der";
    private static final String SELECT_STAFF_BY_ID = "select st.id, st.name, st.email, st.address, st.phone, " +
            "st.salary,st.id_depart, de.id_der, de.name from staffmanager st join departmentStaff de on st.id_depart = de.id_der where st.id = ?";
    private static final String INSERT = "insert into staffmanager(id, name, email, address, phone, salary, id_depart) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_STAFF = "update staffmanager set name = ?, email =?, address=?, phone=?, salary=?, id_depart=? where id=?";
    private static final String DELETE_STAFF = "delete from staffmanager where id = ?";
    public List<Staff> findAll() {
        List<Staff> staff = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SELECT_ALL_STAFFS);
            rs = statement.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("st.id"));
                String name = rs.getString("st.name");
                String email = rs.getString("st.email");
                String address = rs.getString("st.address");
                String phoneNumber = rs.getString("st.phone");
                double salary = Double.parseDouble(rs.getString("st.salary"));
                int id_depart = Integer.parseInt(rs.getString("st.id_depart"));
                Department department = departmentService.findById(id_depart);
                staff.add(new Staff(id, name, email, address, phoneNumber, salary, department));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return staff;
    }

    public void save(Staff staff) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, staff.getId());
            statement.setString(2, staff.getName());
            statement.setString(3, staff.getEmail());
            statement.setString(4, staff.getAddress());
            statement.setString(5, staff.getPhoneNumber());
            statement.setDouble(6, staff.getSalary());
            statement.setInt(7, staff.getId_department());
            statement.executeUpdate();
            connection.commit();
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }finally {
            try {
                if (statement != null) statement.close();
                if (connection != null)connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public Staff findById(int id) {
        Staff staff = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SELECT_STAFF_BY_ID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("st.name");
                String email = rs.getString("st.email");
                String address = rs.getString("st.address");
                String phoneNumber = rs.getString("st.phone");
                double salary = Double.parseDouble(rs.getString("st.salary"));
                int id_depart = Integer.parseInt(rs.getString("st.id_depart"));
                staff = new Staff(id, name, email, address, phoneNumber, salary, id_depart);
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return staff;
    }

    public boolean update(int id, Staff staff) {
        boolean rowUpdate = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(UPDATE_STAFF);
            statement.setString(1, staff.getName());
            statement.setString(2, staff.getEmail());
            statement.setString(3, staff.getAddress());
            statement.setString(4, staff.getPhoneNumber());
            statement.setDouble(5, staff.getSalary());
            statement.setInt(6, staff.getId_department());
            statement.setInt(7, staff.getId());
            rowUpdate = statement.executeUpdate() > 0;
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rowUpdate;
        }
    }


        public boolean remove(int id) {
        boolean row = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(DELETE_STAFF);
            statement.setInt(1, id);
            row = statement.executeUpdate() > 0;
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return row;
    }
}
