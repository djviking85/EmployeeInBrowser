package pro.sky.employe25.employeers.Employer.Service;

import pro.sky.employe25.employeers.Employer.Model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartamentService {
    Employee getEmployeeWithMinSalary(int departmentId);

    Employee getEmployeeWithMaxSalary(int departmentId);

    Map<String, List<Employee>> getAll(Integer departmentId);
}
