package pro.sky.employe25.employeers.exceprion;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName, float salary, int departamentId);

    Employee find(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    List<Employee> getAll();
}
