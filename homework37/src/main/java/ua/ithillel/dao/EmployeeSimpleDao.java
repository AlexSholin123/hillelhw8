package ua.ithillel.dao;

import ua.ithillel.model.Employee;

import java.util.*;

public class EmployeeSimpleDao implements EmployeeDao {
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public Long addEmployee(Employee employee) {
        Long employeeId = generateId();
        employee.setId(employeeId);
        employeeList.add(employee);
        return employeeId;
    }

    private long generateId() {
        long id = employeeList.stream()
                .mapToLong(Employee::getId)
                .max()
                .orElse(0L);
        return ++id;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee oldEmployee = getEmployee(employee.getId());
        if(Objects.nonNull(oldEmployee)) {
            oldEmployee.setName(employee.getName());
            oldEmployee.setSalary(employee.getSalary());
            oldEmployee.setDepartmentId(employee.getDepartmentId());
            oldEmployee.setChiefId(employee.getChiefId());
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeList.removeIf(x -> x.getId().equals(id));
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeList.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> findEmployees() {
        return employeeList;
    }
}
