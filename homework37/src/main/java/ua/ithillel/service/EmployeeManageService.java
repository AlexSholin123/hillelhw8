package ua.ithillel.service;

import ua.ithillel.dao.EmployeeDao;
import ua.ithillel.dao.EmployeeDataBaseDao;
import ua.ithillel.dao.EmployeeSingleton;
import ua.ithillel.model.Employee;

import java.net.URISyntaxException;
import java.util.List;

public class EmployeeManageService {
   // private final EmployeeDao  employeeDao = EmployeeSingleton.getInstance().getEmployeeDao();
    private final EmployeeDao  employeeDao = new EmployeeDataBaseDao();
    private final RandomHttpService randomHttpService = new RandomHttpService();

    public Long add(Employee employee) throws URISyntaxException {
        int salary = randomHttpService.getNumber(1000,10000);
        employee.setSalary(salary);
        Long id = employeeDao.addEmployee(employee);
        return id;
    }

    public void update(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void delete(Long id) {
        employeeDao.deleteEmployee(id);
    }

    public Employee get(Long id) {

        return employeeDao.getEmployee(id);
    }

    public List<Employee> findAll() {
        return employeeDao.findEmployees();
    }

}
