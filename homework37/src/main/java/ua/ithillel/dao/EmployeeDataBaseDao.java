package ua.ithillel.dao;

import ua.ithillel.model.Employee;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ua.ithillel.util.AppConstants.ID;

public class EmployeeDataBaseDao implements EmployeeDao {
    private final String url = "jdbc:postgresql://localhost:5432/testdb";
    private final String user = "postgres";
    private final String password = "1234";

    private static final String INSERT = "INSERT INTO employee (department_id, chief_id, name, salary) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "update employee set department_id=?, chief_id=?, name=?, salary=? where id = ?";
    private static final String DELETE = "delete from employee where id = ?";
    private static final String SELECT_ONE = "select * from employee where id = ?";
    private static final String SELECT = "select * from employee";

    @Override
    public Long addEmployee(Employee employee) {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, employee.getDepartmentId());
            stmt.setString(3, employee.getName());
            stmt.setLong(4, employee.getSalary());
            if (Objects.isNull(employee.getChiefId())) {
                stmt.setNull(2, Types.NULL);
            } else {
                stmt.setLong(2, employee.getChiefId());
            }
            stmt.executeUpdate();
            ResultSet gk = stmt.getGeneratedKeys();
            if (gk.next()) {
                return gk.getLong(ID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            PreparedStatement stmt = con.prepareStatement(UPDATE);
            stmt.setLong(1, employee.getDepartmentId());
            stmt.setString(3, employee.getName());
            stmt.setLong(4, employee.getSalary());
            stmt.setLong(5, employee.getId());
            if (Objects.isNull(employee.getChiefId())) {
                stmt.setNull(2, Types.NULL);
            } else {
                stmt.setLong(2, employee.getChiefId());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = con.prepareStatement(DELETE);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployee(Long id) {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = con.prepareStatement(SELECT_ONE);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Employee(resultSet.getLong(ID),
                    resultSet.getLong("department_id"),
                    resultSet.getLong("chief_id"),
                    resultSet.getString("name"),
                    resultSet.getInt("salary"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                Long chief_id = resultSet.getLong("chief_id");
                if (resultSet.wasNull()) {
                    chief_id = null;
                }
                Employee employee = new Employee(resultSet.getLong(ID),

                        resultSet.getLong("department_id"),
                        chief_id,
                        resultSet.getString("name"),
                        resultSet.getInt("salary"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}

