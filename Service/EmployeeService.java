package pro.sky.employe25.employeers.Employer.Service;

import pro.sky.employe25.employeers.Employer.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName, float salary, int departmentId);

    Employee find(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    List<Employee> getAll();
}
