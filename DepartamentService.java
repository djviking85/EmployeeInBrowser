package pro.sky.employe25.employeers.exceprion;

import java.util.List;
import java.util.Map;

public interface DepartamentService {
    Employee getEmployeeWithMinSalary(int departamentId);

    Employee getEmployeeWithMaxSalary(int departamentId);

    Map<String, List<Employee>> getAll(Integer departamentId);
}
