import lombok.SneakyThrows;
import ua.ithillel.model.Employee;
import ua.ithillel.service.EmployeeManageService;
import ua.ithillel.util.AppConfig;

public class EmployeeSimpleMain {
    @SneakyThrows
    public static void main(String[] args) {
        EmployeeManageService employeeManageService = new EmployeeManageService();
        AppConfig.init();
        Employee nazarov3 = new Employee(31L,1L, 1L, "Назаров Петр Петрович", 35000);
        employeeManageService.update(nazarov3);
        System.out.println(System.getenv("APP_DIR"));

    }

}