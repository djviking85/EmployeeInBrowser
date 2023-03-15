package pro.sky.employe25.employeers.exceprion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentService {
    private final EmployeeService employeeService;

    @Autowired
    public DepartamentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
@Override
    public Employee getEmployeeWithMinSalary(int departamentId) {
        List<Employee> allEmployes = employeeService.getAll();
        float minSalary = Float.MAX_VALUE;
        Employee employeeInDepWithMinSalary = null;

        for (Employee e : allEmployes) {
            if (e.getDepartament().getId() == departamentId && e.getSalary() < minSalary) {
                minSalary = e.getSalary();
                employeeInDepWithMinSalary = e;
            }
            
        }
        return employeeInDepWithMinSalary;

    }
@Override
    public Employee getEmployeeWithMaxSalary(int departamentId) {

    }
    @Override
    public Employee getAll(int departamentId) {


    }

}
