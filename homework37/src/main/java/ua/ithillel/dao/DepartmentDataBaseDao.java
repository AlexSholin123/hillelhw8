package ua.ithillel.dao;

import lombok.SneakyThrows;
import ua.ithillel.dbconnect.DatabaseConnectionSingleton;
import ua.ithillel.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDataBaseDao implements DepartmentDao {
    private Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
    @Override
    @SneakyThrows
    public Long addDepartment(Department department) {
        String sql = "INSERT INTO department (name) VALUES (?)";
        PreparedStatement stmt = con.prepareStatement(sql, new String[]{"id"});
        stmt.setString(1, department.getName());
        stmt.executeUpdate();
        ResultSet gk = stmt.getGeneratedKeys();
        if (gk.next()) {
            return gk.getLong("id");
        }
        return null;
    }

    @Override
    @SneakyThrows
    public void updateDepartment(Department department) {
        String sql = "update department set name=? where id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, department.getName());
        stmt.setLong(2, department.getId());
        stmt.executeUpdate();
    }

    @Override
    @SneakyThrows
    public void deleteDepartment(Long id) {
        String sql = "delete from department where id = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setLong(1, id);
        statement.executeUpdate();
    }

    @Override
    @SneakyThrows
    public Department getDepartment(Long id) {
        String sql = "select * from department where id = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return new Department(resultSet.getLong("id"),
                resultSet.getString("name"));
    }

    @Override
    @SneakyThrows
    public List<Department> findDepartments() {
        List<Department> departments = new ArrayList<>();
        String sql = "select * from department";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Department department = new Department(resultSet.getLong("id"),
                    resultSet.getString("name"));
            departments.add(department);
        }
        return departments;
    }

}
