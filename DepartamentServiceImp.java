package pro.sky.employe25.employeers.exceprion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartamentServiceImp implements DepartamentService {
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public DepartamentServiceImp(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
@Override
    public Employee getEmployeeWithMinSalary(int departmentId) {
        List<Employee> allEmployes = employeeService.getAll();
        float minSalary = Float.MAX_VALUE;
        Employee employeeInDepWithMinSalary = null;

        for (Employee e : allEmployes) {
            if (e.getDepartament().getId() == departmentId && e.getSalary() < minSalary) {
                minSalary = e.getSalary();
                employeeInDepWithMinSalary = e;
            }
            
        }
        return employeeInDepWithMinSalary;

    }
@Override
    public Employee getEmployeeWithMaxSalary(int departmentId) {
    List<Employee> allEmployes = employeeService.getAll();
    float maxSalary = Float.MAX_VALUE;
    Employee employeeInDepWithMaxSalary = null;

    for (Employee e : allEmployes) {
        if (e.getDepartament().getId() == departmentId && e.getSalary() < maxSalary) {
            maxSalary = e.getSalary();
            employeeInDepWithMaxSalary = e;
        }

    }
    return employeeInDepWithMaxSalary;

    }
    @Override
    public Map<String, List<Employee>> getAll(Integer departmentId) {
        List<Employee> allEmployees = employeeService.getAll();
        if (departmentId == null) {
            return groupEmployeeByDepartament(allEmployees);
        }
        List<Employee> result = new ArrayList<>();
        for (Employee e : allEmployees) {
            if (e.getDepartament().getId() == departmentId) {
                result.add(e);

            }
        }
        return groupEmployeeByDepartament(result);
    }
// группируем сотрудников по отделам
    private Map<String, List<Employee>> groupEmployeeByDepartament(List<Employee> employees) {
        Map<String, List<Employee>> employersByDeportament = new HashMap<>();
        // проходим по сотрудникам
        for (Employee e :employees ) {
            // в ключ деп нейм ищем по депортаменту и имени и добавляем сотрудника
            String depName = e.getDepartament().getName();
            // если депортамент существует то добавляем сотудника в наш лист
            if (employersByDeportament.containsKey(depName)) {
                List<Employee> newList = employersByDeportament.get(depName);
                newList.add(e);
                employersByDeportament.put(depName, newList);
            } else  {
                // если нет мы создаем новыйлист
                List<Employee> newList = new ArrayList<>();
                newList.add(e);
                employersByDeportament.put(depName, newList);
            }
            }
        return employersByDeportament;

    }


}
